package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.UserCollectTask;
import com.chupinadventure.hackathon.domain.UserCollectTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CollectedTrashSummaryService {

    private final UserCollectTaskRepository userCollectTaskRepository;

    public UserCollectSummary summary(final long collectId) {
        final UserCollectTask collectTask = userCollectTaskRepository.findById(collectId)
                .orElseThrow(() -> new RuntimeException("not exist collectTask"));

//        return new UserCollectSummary(collectTask.getSummaries()
//                .entrySet()
//                .stream()
//                .map(entry -> new UserCollectSummary.CollectedTrashCount(entry.getKey(), entry.getValue()))
//                .collect(ImmutableSet.toImmutableSet()));

        return null;
    }
}
