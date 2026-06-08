package com.uploading.csvfile.domain.models;

import java.time.LocalDateTime;

public record ImportReadingCommand(
        String sensorId,
        Double readingValue,
        LocalDateTime readingDatetime,
        String location) {
}
