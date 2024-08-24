package com.chupinadventure.hackathon.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Converter
public class MapToJsonConverter implements AttributeConverter<Map<TrashType, Integer>, String> {

    private final TypeReference<Map<TrashType, Integer>> TYPE_REFERENCE = new TypeReference<>() {
    };

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(final Map<TrashType, Integer> attribute) {
        if (attribute == null) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (final JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting map to JSON string.", e);
        }
    }

    @Override
    public Map<TrashType, Integer> convertToEntityAttribute(final String rawData) {
        if (rawData == null || rawData.isEmpty()) {
            return new HashMap<>();
        }
        try {
            return objectMapper.readValue(rawData, TYPE_REFERENCE);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to map.", e);
        }
    }
}