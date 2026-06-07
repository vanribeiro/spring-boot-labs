package com.uploading.csvfile.domain.repository;

import java.util.List;

import com.uploading.csvfile.domain.models.Reading;

public interface ReadingRepository {
    Reading save(Reading reading);
    List<Reading> saveBySensor(String sensorId);
}
