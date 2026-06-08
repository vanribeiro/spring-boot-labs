package com.uploading.csvfile.infra.adapters;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.uploading.csvfile.domain.models.Sensor;
import com.uploading.csvfile.domain.repository.SensorRepository;
import com.uploading.csvfile.infra.persistence.entity.SensorEntity;
import com.uploading.csvfile.infra.persistence.repository.SensorJpaRepository;

@Repository
public class SensorRepositoryAdapter implements SensorRepository {

    private final SensorJpaRepository jpaRepository;

    public SensorRepositoryAdapter(SensorJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Sensor salvar(Sensor sensor) {
        SensorEntity entity = toEntity(sensor);
        SensorEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Sensor> buscarPorId(String id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Sensor> buscarTodos() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public void deletar(String id) {
        jpaRepository.deleteById(id);
    }

    private Sensor toDomain(SensorEntity entity) {
        return new Sensor(
                entity.getId(),
                entity.getName(),
                entity.getLocation(),
                entity.getActive(),
                entity.getSensor());
    }

    private SensorEntity toEntity(Sensor sensor) {
        SensorEntity entity = new SensorEntity();
        entity.setId(sensor.getId());
        entity.setName(sensor.getName());
        entity.setLocation(sensor.getLocation());
        entity.setActive(sensor.isActive());
        entity.setSensor(sensor.getType());
        return entity;
    }
}
