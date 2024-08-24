package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.Trash;
import com.chupinadventure.hackathon.domain.TrashRepository;
import com.chupinadventure.hackathon.domain.UserLocation;
import com.chupinadventure.hackathon.domain.UserLocationRepository;
import com.chupinadventure.hackathon.global.PointAndRadius;
import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
@AllArgsConstructor
public class CollectedTrashSummaryService {

    private final TrashRepository trashRepository;
    private final UserLocationRepository userLocationRepository;

    public Set<Trash> summary(final long collectId) {
        final Set<UserLocation> userLocations = userLocationRepository.findAllByCollectId(collectId);

        final Set<Long> trashIds = userLocations.stream()
                .map(userLocation -> new PointAndRadius(userLocation.getLocation().getX(), userLocation.getLocation().getY(), 50))
                .map(pointAndRadius -> trashRepository.findDistanceSphere(pointAndRadius.getLongitude(), pointAndRadius.getLatitude(), pointAndRadius.getRadiusMeter()))
                .flatMap(Collection::stream)
                .collect(ImmutableSet.toImmutableSet());

        return ImmutableSet.copyOf(trashRepository.findAllById(trashIds));
    }
}
