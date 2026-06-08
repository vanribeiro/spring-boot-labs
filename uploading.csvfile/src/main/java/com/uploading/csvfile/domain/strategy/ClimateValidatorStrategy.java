package com.uploading.csvfile.domain.strategy;

import org.springframework.stereotype.Component;
import com.uploading.csvfile.domain.enums.SensorType;
import com.uploading.csvfile.domain.exception.BusinessRuleException;
import com.uploading.csvfile.domain.models.Reading;

@Component
public class ClimateValidatorStrategy implements SensorValidatorStrategy {
    @Override
    public boolean support(SensorType type) {
        return type == SensorType.CLIMATE;
    }

    @Override
    public void validate(Reading reading) {
        if (reading.getReadingValue() < -50 || reading.getReadingValue() > 60) {
            throw new BusinessRuleException("Valor de temperatura inválido! Deve estar entre -50 e 60.");
        }
    }
}