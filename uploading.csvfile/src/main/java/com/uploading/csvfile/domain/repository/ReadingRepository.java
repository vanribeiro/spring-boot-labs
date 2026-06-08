package com.uploading.csvfile.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uploading.csvfile.domain.models.Reading;

public interface ReadingRepository {
    Reading save(Reading reading);
    List<Reading> saveBySensor(String sensorId);
    void saveAll(List<Reading> readings);
    boolean exists(String sensorId, LocalDateTime readingDatetime);
}
