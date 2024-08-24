package com.chupinadventure.hackathon.presentation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import org.locationtech.jts.geom.Point;

@ToString
@Getter
public final class Location {
    private final double lng;
    private final double lat;

    @JsonCreator
    public Location(@JsonProperty("lng") final double lng,
                    @JsonProperty("lat") final double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public static Location of(final Point position) {
        return new Location(position.getX(), position.getY());
    }
}
