package com.uploading.csvfile.infra.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uploading.csvfile.infra.persistence.entity.SensorLocationEntity;

public interface SensorLocationJpaRepository extends JpaRepository<SensorLocationEntity, String> {
    Optional<SensorLocationEntity> findBySensorIdAndEndDateIsNull(String sensorId);
}
