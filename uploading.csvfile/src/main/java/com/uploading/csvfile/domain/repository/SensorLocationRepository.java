package com.uploading.csvfile.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.uploading.csvfile.domain.models.SensorLocation;

public interface SensorLocationRepository {
    SensorLocation save(SensorLocation location);
    Optional<SensorLocation> findBySensor(String id);
    Optional<SensorLocation> findBySensorAndDate(String sensorId, LocalDateTime data);
    List<SensorLocation> findByAll(SensorLocation id);
}
