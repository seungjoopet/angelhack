package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.UserCollectTask;
import com.chupinadventure.hackathon.domain.UserCollectTaskRepository;
import com.chupinadventure.hackathon.domain.UserLocation;
import com.chupinadventure.hackathon.domain.UserLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class UserCollectingService {

    private final UserLocationRepository userLocationRepository;
    private final UserCollectTaskRepository userRouteTaskRepository;

    @Transactional
    public long start(final String userId) {
        final UserCollectTask task = UserCollectTask.of(userId);
        userRouteTaskRepository.save(task);

        return task.getId();
    }

    @Transactional
    public void collect(final UserLocationCollectCommand command) {
        final UserLocation userLocation = UserLocation.of(command);
        userLocationRepository.save(userLocation);
    }

    @Transactional
    public void end(final UserLocationEndCommand command) {
        final UserCollectTask task = userRouteTaskRepository.findById(command.getCollectId())
                .orElseThrow(() -> new RuntimeException("task is not exist"));
        task.end();
    }
}
