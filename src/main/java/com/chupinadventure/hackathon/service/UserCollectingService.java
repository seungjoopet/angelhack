package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.*;
import com.chupinadventure.hackathon.global.PointAndRadius;
import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserCollectingService {

    private final UserLocationRepository userLocationRepository;
    private final UserCollectTaskRepository userCollectTaskRepository;
    private final TrashRepository trashRepository;

    @Transactional
    public long start(final String userId) {
        final UserCollectTask task = UserCollectTask.of(userId);
        userCollectTaskRepository.save(task);

        return task.getId();
    }

    @Transactional
    public void collect(final UserLocationCollectCommand command) {
        final UserLocation userLocation = UserLocation.of(command);
        userLocationRepository.save(userLocation);
    }

    @Transactional
    public void end(final UserLocationEndCommand command) {
        final UserCollectTask task = userCollectTaskRepository.findById(command.getCollectId())
                .orElseThrow(() -> new RuntimeException("task is not exist"));

        final Set<Long> trashIds = getTrashIds(command.getCollectId());
        final Set<Trash> trashes = ImmutableSet.copyOf(trashRepository.findAllById(trashIds));

        final Map<TrashType, Integer> map = new HashMap<>();
        trashes.forEach(trash -> {
            map.put(trash.getType(), map.getOrDefault(trash.getType(), 0) + 1);
            trash.delete();
        });

        task.end(map);
    }

    private Set<Long> getTrashIds(final long collectId) {
        final Set<UserLocation> userLocations = userLocationRepository.findAllByCollectId(collectId);

        return userLocations.stream()
                .map(userLocation -> new PointAndRadius(userLocation.getLocation().getY(), userLocation.getLocation().getX(), 50))
                .map(pointAndRadius -> trashRepository.findDistanceSphere(pointAndRadius.getLongitude(), pointAndRadius.getLatitude(), pointAndRadius.getRadiusMeter()))
                .flatMap(Collection::stream)
                .collect(ImmutableSet.toImmutableSet());
    }
}
