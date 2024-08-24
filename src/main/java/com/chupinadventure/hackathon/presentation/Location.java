package com.chupinadventure.hackathon.presentation;

import lombok.Getter;

@Getter
public final class Location {

    private final double lat;
    private final double lng;

    public Location(final double lat, final double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
