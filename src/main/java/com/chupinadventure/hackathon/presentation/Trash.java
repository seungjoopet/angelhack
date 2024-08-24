package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.TrashType;
import lombok.Getter;

@Getter
public final class Trash {
    private final TrashType trashType;
    private final double lat;
    private final double lng;

    public Trash(final TrashType trashType, final double lat, final double lng) {
        this.trashType = trashType;
        this.lat = lat;
        this.lng = lng;
    }
}
