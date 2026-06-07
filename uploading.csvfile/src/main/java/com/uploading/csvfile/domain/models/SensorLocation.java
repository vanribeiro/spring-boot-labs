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
    private LocalDateTime startDate;
    private LocalDateTime Enddate;

    public SensorLocation(
            String id,
            String sensorId,
            String locacation,
            LocalDateTime startDate,
            LocalDateTime Enddate) {
        this.id = id;
        this.sensorId = sensorId;
        this.locacation = locacation;
        this.startDate = startDate;
        this.Enddate = Enddate;

        if (sensorId == null) {
            throw new BusinessRuleException("Sensor é obrigatório!");
        }

        if (locacation == null || locacation.isBlank()) {
            throw new BusinessRuleException("Localização é obrigatória!");
        }

        if (startDate == null) {
            throw new BusinessRuleException("Data de inicio é mandatória!");
        }
    }

    public void encerrar(LocalDateTime dataEncerramento) {
        if (this.Enddate != null) {
            throw new BusinessRuleException("Esta localização já foi encerrada");
        }
        this.Enddate = dataEncerramento;
    }

    public boolean isAtivo() {
        return this.Enddate == null;
    }
}
