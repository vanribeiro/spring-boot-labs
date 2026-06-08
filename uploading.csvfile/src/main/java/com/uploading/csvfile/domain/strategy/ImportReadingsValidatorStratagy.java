package com.uploading.csvfile.domain.strategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uploading.csvfile.domain.exception.BusinessRuleException;
import com.uploading.csvfile.domain.models.ImportReadingCommand;
import com.uploading.csvfile.domain.models.Reading;
import com.uploading.csvfile.domain.models.Sensor;
import com.uploading.csvfile.domain.repository.ReadingRepository;
import com.uploading.csvfile.domain.repository.SensorRepository;

@Service
public class ImportReadingsValidatorStratagy implements ImportReadingsStratagy {

    private final List<SensorValidatorStrategy> validators;
    private final ReadingRepository repository;
    private final SensorRepository sensorRepository;

    public ImportReadingsValidatorStratagy(List<SensorValidatorStrategy> validators,
            ReadingRepository repository,
            SensorRepository sensorRepository) {
        this.validators = validators;
        this.repository = repository;
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void run(List<ImportReadingCommand> commands) {
        List<Reading> readings = new ArrayList<>();

        for (ImportReadingCommand cmd : commands) {
            if (repository.exists(cmd.sensorId(), cmd.readingDatetime())) {
                continue; 
            }
            Sensor sensor = sensorRepository.buscarPorId(cmd.sensorId())
                    .orElseThrow(() -> new BusinessRuleException(
                            "Sensor não encontrado: " + cmd.sensorId()));

            Reading reading = new Reading(
                    null, sensor, cmd.readingValue(),
                    cmd.readingDatetime(), cmd.location());

            SensorValidatorStrategy validator = validators.stream()
                    .filter(v -> v.support(sensor.getType()))
                    .findFirst()
                    .orElseThrow(() -> new BusinessRuleException(
                            "Nenhum validador para: " + sensor.getType()));

            validator.validate(reading);
            readings.add(reading);
        }

        repository.saveAll(readings);
    }
}
