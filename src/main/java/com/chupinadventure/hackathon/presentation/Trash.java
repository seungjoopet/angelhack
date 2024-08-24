package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.TrashType;
import lombok.Getter;

@Getter
public final class Trash {
    private final TrashType type;
    private final Location location;

    public Trash(final TrashType type, final Location location) {
        this.type = type;
        this.location = location;
    }
}
