package com.uploading.csvfile.domain.models;

import com.uploading.csvfile.domain.enums.SensorType;
import com.uploading.csvfile.domain.exception.ValidationException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Sensor {
    private String id;
    private String name;
    private String location;
    private boolean active;
    private SensorType type;
    
    public Sensor(
        String id,
        String name,
        String location,
        boolean active,
        SensorType type
    ) {

        if (name == null || name.isBlank()) {
            throw new ValidationException("Nome do sensor é obrigatório");
        }

        if (location == null || location.isBlank()) {
            throw new ValidationException("Localização é obrigatório");
        }

        if (type == null) {
            throw new ValidationException("Tipo do sensor é obrigatório");
        }

        this.id = id;
        this.name = name;
        this.location = location;
        this.active = active;
        this.type = type;
    }

    public void alterarlocation(String novalocation) {
        if (novalocation == null || novalocation.isBlank()) {
            throw new ValidationException("A nova localização não pode ser vazia!");
        }

        this.location = novalocation;
    }

    public void activate() { this.active = true; }
    public void disable() { this.active = false; }
    
    public boolean isActive() { return active; }

}
