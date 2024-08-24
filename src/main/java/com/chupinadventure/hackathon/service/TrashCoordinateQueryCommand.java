package com.chupinadventure.hackathon.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@Builder
public final class TrashCoordinateQueryCommand {
    private final double east;
    private final double west;
    private final double north;
    private final double south;
}
