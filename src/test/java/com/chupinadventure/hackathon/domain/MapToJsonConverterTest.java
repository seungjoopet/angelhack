package com.chupinadventure.hackathon.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapToJsonConverterTest {

    private MapToJsonConverter converter;

    @BeforeEach
    void setUp() {
        converter = new MapToJsonConverter();
    }

    @Test
    void name() {
        // given
        final Map<TrashType, Integer> source = new HashMap<>();
        source.put(TrashType.ETC, 3);

        // when
        final String convertedStrValue = converter.convertToDatabaseColumn(source);
        final Map<TrashType, Integer> result = converter.convertToEntityAttribute(convertedStrValue);

        // then
        assertThat(result).isNotEmpty();
    }
}