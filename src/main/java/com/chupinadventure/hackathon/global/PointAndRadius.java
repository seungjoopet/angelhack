package com.chupinadventure.hackathon.global;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public final class PointAndRadius {
    private final double latitude;
    private final double longitude;
    private final double radiusMeter;
}
