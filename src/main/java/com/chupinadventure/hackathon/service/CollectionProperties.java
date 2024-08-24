package com.chupinadventure.hackathon.service;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public final class CollectionProperties {
    private double radiusMeter = 10.0;
}
