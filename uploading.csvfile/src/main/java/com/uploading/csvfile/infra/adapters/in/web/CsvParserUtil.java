package com.uploading.csvfile.infra.adapters.in.web;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.uploading.csvfile.infra.adapters.in.web.dto.ReadingLineDto;

public class CsvParserUtil {
    public static List<ReadingLineDto> parse(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            CsvToBean<ReadingLineDto> csvToBean = new CsvToBeanBuilder<ReadingLineDto>(reader)
                    .withType(ReadingLineDto.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException("Falha ao processar o arquivo CSV");
        }
    }
}
