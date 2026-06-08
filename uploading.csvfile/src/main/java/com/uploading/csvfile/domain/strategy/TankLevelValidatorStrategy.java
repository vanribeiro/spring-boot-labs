package com.uploading.csvfile.domain.strategy;

import org.springframework.stereotype.Component;
import com.uploading.csvfile.domain.enums.SensorType;
import com.uploading.csvfile.domain.exception.BusinessRuleException;
import com.uploading.csvfile.domain.models.Reading;

@Component
public class TankLevelValidatorStrategy implements SensorValidatorStrategy {
    @Override
    public boolean support(SensorType type) {
        return type == SensorType.TANK_LEVEL;
    }

    @Override
    public void validate(Reading reading) {
        if (reading.getReadingValue() < 0 || reading.getReadingValue() > 100) {
            throw new BusinessRuleException("Nível do tanque inválido! Deve estar entre 0 e 100.");
        }
    }
}