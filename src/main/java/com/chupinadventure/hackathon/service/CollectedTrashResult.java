package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.TrashType;
import lombok.Getter;

import java.util.Set;

@Getter
public final class CollectedTrashResult {
    private final String userId;
    private final Set<CollectedTrash> collectedTrashes;

    public CollectedTrashResult(final String userId, final Set<CollectedTrash> collectedTrashes) {
        this.userId = userId;
        this.collectedTrashes = collectedTrashes;
    }

    @Getter
    public static final class CollectedTrash {
        private final long id;
        private final TrashType type;

        public CollectedTrash(final long id, final TrashType type) {
            this.id = id;
            this.type = type;
        }
    }
}
