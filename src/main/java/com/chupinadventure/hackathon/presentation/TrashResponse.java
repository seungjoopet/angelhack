package com.chupinadventure.hackathon.presentation;

import com.chupinadventure.hackathon.domain.Trash;
import com.chupinadventure.hackathon.domain.TrashType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public final class TrashResponse {
    private final long id;
    private final TrashType type;
    private final Location location;

    public static TrashResponse of(final Trash trash) {
        return new TrashResponse(trash.getId(), trash.getType(), Location.of(trash.getLocation()));
    }
}
