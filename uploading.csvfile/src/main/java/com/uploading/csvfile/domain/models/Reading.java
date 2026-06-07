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
    private Double readingValue;
    private LocalDateTime readingDatetime;
    private String location;

    public Reading(
            Long id,
            Sensor sensor,
            Double readingValue,
            LocalDateTime readingDatetime,
            String location) {
        this.id = id;
        this.sensor = sensor;
        this.readingValue = readingValue;
        this.readingDatetime = readingDatetime;
        this.location = location;

        if (sensor == null) {
            throw new ValidationException("Sensor é obrigatório!");
        }

        if (location == null || location.isBlank()) {
            throw new ValidationException("Localização é obrigatória!");
        }

        if (readingValue == null) {
            throw new ValidationException("Valor da leitura é obrigatório!");
        }

        if (readingDatetime == null) {
            throw new ValidationException("Data/hora é obrigatória!");
        }
    }
    
    public Sensor getSensor() {
        return sensor;
    }
}
