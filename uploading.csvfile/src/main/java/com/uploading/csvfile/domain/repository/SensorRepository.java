package com.uploading.csvfile.domain.repository;

import java.util.List;
import java.util.Optional;

import com.uploading.csvfile.domain.models.Sensor;

public interface SensorRepository {
    Sensor salvar(Sensor sensor);
    Optional<Sensor> buscarPorId(String id);
    List<Sensor> buscarTodos();
    void deletar(String id);
}
