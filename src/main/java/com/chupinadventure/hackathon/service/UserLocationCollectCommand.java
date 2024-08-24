package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.presentation.Location;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class UserLocationCollectCommand {
    private final String userId;
    private final long collectId;
    private final double latitude;
    private final double longitude;

    @JsonCreator
    public UserLocationCollectCommand(@JsonProperty("userId") final String userId,
                                      @JsonProperty("collectId") final long collectId,
                                      @JsonProperty("location") final Location location) {

        this.userId = userId;
        this.collectId = collectId;
        this.latitude = location.getLat();
        this.longitude = location.getLng();
    }
}
