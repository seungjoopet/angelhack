package com.chupinadventure.hackathon.presentation;

import lombok.Getter;

@Getter
public class CollectStartResponse {
    private final long collectId;

    public CollectStartResponse(final long collectId) {
        this.collectId = collectId;
    }
}
