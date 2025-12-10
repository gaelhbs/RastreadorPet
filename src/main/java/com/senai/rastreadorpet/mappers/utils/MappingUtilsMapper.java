package com.senai.rastreadorpet.mappers.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class MappingUtilsMapper {

    public LocalDateTime toLocalDateTime(Long unixTimestamp) {
        if (unixTimestamp == null) {
            return null;
        }
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(unixTimestamp), ZoneOffset.UTC);
    }
}