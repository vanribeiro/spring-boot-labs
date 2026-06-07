package com.uploading.csvfile.domain.models;

import java.time.LocalDateTime;

import com.uploading.csvfile.domain.exception.ValidationException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Reading {
    private Long id;
    private Sensor sensor;
    private Double value;
    private LocalDateTime datetime;
    private String location;

    public Reading(
            Long id,
            Sensor sensor,
            Double value,
            LocalDateTime datetime,
            String location) {
        this.id = id;
        this.sensor = sensor;
        this.value = value;
        this.datetime = datetime;
        this.location = location;

        if (sensor == null) {
            throw new ValidationException("Sensor é obrigatório!");
        }

        if (location == null || location.isBlank()) {
            throw new ValidationException("Localização é obrigatória!");
        }

        if (value == null) {
            throw new ValidationException("Valor da leitura é obrigatório!");
        }

        if (datetime == null) {
            throw new ValidationException("Data/hora é obrigatória!");
        }
    }
    
    public Sensor getSensor() {
        return sensor;
    }
}
