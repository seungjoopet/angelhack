package com.chupinadventure.hackathon.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Converter
public class MapToJsonConverter implements AttributeConverter<Map<String, Integer>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(final Map<String, Integer> attribute) {
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
    public Map<String, Integer> convertToEntityAttribute(final String rawData) {
        if (rawData == null || rawData.isEmpty()) {
            return new HashMap<>();
        }
        try {
            return objectMapper.readValue(rawData, HashMap.class);
        } catch (final IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to map.", e);
        }
    }
}