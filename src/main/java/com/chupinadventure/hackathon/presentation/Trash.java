package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.TrashType;
import lombok.Getter;

@Getter
public final class Trash {
    private final TrashType trashType;
    private final Location location;

    public Trash(final TrashType trashType, final Location location) {
        this.trashType = trashType;
        this.location = location;
    }
}
