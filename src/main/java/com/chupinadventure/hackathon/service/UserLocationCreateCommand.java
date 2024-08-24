package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.presentation.Location;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class UserLocationCreateCommand {
    private final String userId;
    private final double latitude;
    private final double longitude;

    @JsonCreator
    public UserLocationCreateCommand(@JsonProperty("userId") final String userId,
                                     @JsonProperty("location") final Location location) {

        this.userId = userId;
        this.latitude = location.getLat();
        this.longitude = location.getLng();
    }
}
