package com.uploading.csvfile.infra.adapters.out;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uploading.csvfile.domain.models.Reading;
import com.uploading.csvfile.domain.repository.ReadingRepository;
import com.uploading.csvfile.infra.persistence.entity.ReadingEntity;
import com.uploading.csvfile.infra.persistence.entity.SensorEntity;
import com.uploading.csvfile.infra.persistence.entity.SensorLocationEntity;
import com.uploading.csvfile.infra.persistence.repository.ReadingJpaRepository;
import com.uploading.csvfile.infra.persistence.repository.SensorLocationJpaRepository;

@Repository
public class ReadingRepositoryAdapter implements ReadingRepository {

    private final ReadingJpaRepository jpaRepository;
    private final SensorLocationJpaRepository locationJpaRepository;

    public ReadingRepositoryAdapter(ReadingJpaRepository jpaRepository,
            SensorLocationJpaRepository sensorLocationJpaRepository) {
        this.jpaRepository = jpaRepository;
        this.locationJpaRepository = sensorLocationJpaRepository;
    }

    @Override
    public Reading save(Reading reading) {
        ReadingEntity entity = toEntity(reading);
        jpaRepository.save(entity);
        return reading;
    }

    @Override
    public List<Reading> saveBySensor(String sensorId) {
        return jpaRepository.findBySensorId(sensorId).stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public void saveAll(List<Reading> readings) {
        List<ReadingEntity> entities = readings.stream()
                .map(this::toEntity)
                .toList();
        jpaRepository.saveAll(entities);
    }

    @Override
    public boolean exists(String sensorId, LocalDateTime readingDatetime) {
        return jpaRepository.existsBySensorIdAndReadingDatetime(sensorId, readingDatetime);
    }

    private ReadingEntity toEntity(Reading reading) {
        ReadingEntity entity = new ReadingEntity();

        SensorEntity sensor = new SensorEntity();
        sensor.setId(reading.getSensor().getId());
        entity.setSensor(sensor);

        SensorLocationEntity location = locationJpaRepository
                .findBySensorIdAndEndDateIsNull(reading.getSensor().getId())
                .orElseThrow(() -> new RuntimeException(
                        "Localização ativa não encontrada para sensor: " + reading.getSensor().getId()));
        entity.setLocation(location);

        entity.setReadingValue(reading.getReadingValue());
        entity.setReadingDatetime(reading.getReadingDatetime());
        return entity;
    }

    private Reading toDomain(ReadingEntity entity) {
        return null;
    }

}
