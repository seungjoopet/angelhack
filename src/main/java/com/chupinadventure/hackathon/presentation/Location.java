package com.chupinadventure.hackathon.presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public final class Location {
    private final double lat;
    private final double lng;

    @JsonCreator
    public Location(@JsonProperty("lat") final double lat,
                    @JsonProperty("lng") final double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
