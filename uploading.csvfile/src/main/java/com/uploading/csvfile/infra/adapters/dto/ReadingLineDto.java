package com.uploading.csvfile.infra.adapters.dto;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;

@Getter
public class ReadingLineDto {
    @CsvBindByName(column = "sensor", required = true)
    private String sensorId;

    @CsvBindByName(column = "reading_value", required = true)
    private Double readingValue;

    @CsvBindByName(column = "reading_datetime", required = true)
    private String readingDatetime;

    @CsvBindByName(column = "location", required = true)
    private String location;
}
