package com.uploading.csvfile.infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uploading.csvfile.infra.persistence.entity.SensorEntity;

public interface SensorJpaRepository extends JpaRepository<SensorEntity, String> {
}
