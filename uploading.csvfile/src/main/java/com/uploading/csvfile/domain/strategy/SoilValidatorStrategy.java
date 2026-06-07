package com.uploading.csvfile.domain.strategy;

import com.uploading.csvfile.domain.enums.SensorType;
import com.uploading.csvfile.domain.exception.BusinessRuleException;
import com.uploading.csvfile.domain.models.Reading;

public class SoilValidatorStrategy implements SensorValidatorStrategy{

    @Override
    public boolean suportar(SensorType type) {
        return type == SensorType.SOIL;
    }

    @Override
    public void validar(Reading reading) {
        if(reading.getValue() < 0 || reading.getValue() > 100) {
            throw new BusinessRuleException("Valor lido, de umidade do solo, inválido!");
        }
    }

}
