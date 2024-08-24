package com.chupinadventure.hackathon.service;

import lombok.Getter;

@Getter
public final class UserLocationEndCommand {
    private final String userId;
    private final long collectId;

    public UserLocationEndCommand(final String userId, final long collectId) {
        this.userId = userId;
        this.collectId = collectId;
    }
}
