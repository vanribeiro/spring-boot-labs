package com.uploading.csvfile.domain.models;

import java.time.LocalDateTime;

import com.uploading.csvfile.domain.exception.BusinessRuleException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SensorLocation {
    private String id;
    private String sensorId;
    private String locacation;
    private LocalDateTime dataStart;
    private LocalDateTime dateEnd;

    public SensorLocation(
            String id,
            String sensorId,
            String locacation,
            LocalDateTime dataStart,
            LocalDateTime dateEnd) {
        this.id = id;
        this.sensorId = sensorId;
        this.locacation = locacation;
        this.dataStart = dataStart;
        this.dateEnd = dateEnd;

        if (sensorId == null) {
            throw new BusinessRuleException("Sensor é obrigatório!");
        }

        if (locacation == null || locacation.isBlank()) {
            throw new BusinessRuleException("Localização é obrigatória!");
        }

        if (dataStart == null) {
            throw new BusinessRuleException("Data de inicio é mandatória!");
        }
    }

    public void encerrar(LocalDateTime dataEncerramento) {
        if (this.dateEnd != null) {
            throw new BusinessRuleException("Esta localização já foi encerrada");
        }
        this.dateEnd = dataEncerramento;
    }

    public boolean isAtivo() {
        return this.dateEnd == null;
    }
}
