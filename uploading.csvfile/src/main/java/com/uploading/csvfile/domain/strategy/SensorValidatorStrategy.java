package com.uploading.csvfile.domain.strategy;

import com.uploading.csvfile.domain.enums.SensorType;
import com.uploading.csvfile.domain.models.Reading;

public interface SensorValidatorStrategy {
    boolean support(SensorType type);
    void validate(Reading reading);
}
