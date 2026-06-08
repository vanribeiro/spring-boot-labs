package com.uploading.csvfile.domain.strategy;

import org.springframework.stereotype.Component;
import com.uploading.csvfile.domain.enums.SensorType;
import com.uploading.csvfile.domain.exception.BusinessRuleException;
import com.uploading.csvfile.domain.models.Reading;

@Component
public class PhValidatorStrategy implements SensorValidatorStrategy {
    @Override
    public boolean support(SensorType type) {
        return type == SensorType.PH;
    }

    @Override
    public void validate(Reading reading) {
        if (reading.getReadingValue() < 0 || reading.getReadingValue() > 14) {
            throw new BusinessRuleException("Valor de pH inválido! Deve estar entre 0 e 14.");
        }
    }
}