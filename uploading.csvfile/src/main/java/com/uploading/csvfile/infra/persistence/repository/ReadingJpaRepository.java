package com.uploading.csvfile.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uploading.csvfile.infra.persistence.entity.ReadingEntity;

import java.time.LocalDateTime;
import java.util.List;


public interface ReadingJpaRepository extends JpaRepository<ReadingEntity, String>{
    List<ReadingEntity> findBySensorId(String sensorId);
    boolean existsBySensorIdAndReadingDatetime(String sensorId, LocalDateTime readingDatetime);
}
