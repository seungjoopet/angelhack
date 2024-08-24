package com.chupinadventure.hackathon.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public final class UserLocationEndCommand {
    private final String userId;
    private final long collectId;

    @JsonCreator
    public UserLocationEndCommand(@JsonProperty("userId") final String userId,
                                  @JsonProperty("collectId") final long collectId) {
        this.userId = userId;
        this.collectId = collectId;
    }
}
