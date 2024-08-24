package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.TrashType;
import lombok.Getter;

import java.util.Set;

@Getter
public final class UserCollectSummary {
    private final Set<CollectedTrashCount> collectedTrashCounts;

    public UserCollectSummary(final Set<CollectedTrashCount> collectedTrashCounts) {
        this.collectedTrashCounts = collectedTrashCounts;
    }

    @Getter
    static final class CollectedTrashCount {
        private final TrashType trashType;
        private final int count;

        public CollectedTrashCount(final TrashType trashType, final int count) {
            this.trashType = trashType;
            this.count = count;
        }
    }
}
