package com.chupinadventure.hackathon.service;

import com.chupinadventure.hackathon.domain.TrashType;
import com.chupinadventure.hackathon.presentation.Location;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class TrashCreateCommand {

    private final double latitude;
    private final double longitude;
    private final TrashType type;

    @JsonCreator
    public TrashCreateCommand(@JsonProperty("location") final Location location,
                              @JsonProperty("type") final TrashType type) {
        this.latitude = location.getLat();
        this.longitude = location.getLng();
        this.type = type;
    }
}
