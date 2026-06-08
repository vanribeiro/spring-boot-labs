package com.uploading.csvfile.infra.adapters.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploading.csvfile.domain.models.ImportReadingCommand;
import com.uploading.csvfile.domain.strategy.ImportReadingsStratagy;
import com.uploading.csvfile.infra.adapters.dto.ReadingLineDto;
import com.uploading.csvfile.infra.adapters.util.CsvParserUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/v1/readings")
public class ReadingController {

    private final ImportReadingsStratagy useCase;

    public ReadingController(ImportReadingsStratagy useCase) {
        this.useCase = useCase;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Importar leituras via CSV")
    public ResponseEntity<String> importCsv(
            @Parameter(description = "Arquivo CSV com as leituras") @RequestParam("file") MultipartFile file) {
        try {
            List<ReadingLineDto> dtos = CsvParserUtil.parse(file.getInputStream());

            List<ImportReadingCommand> commands = dtos.stream()
                    .map(dto -> new ImportReadingCommand(
                            dto.getSensorId(),
                            dto.getReadingValue(),
                            LocalDateTime.parse(dto.getReadingDatetime()),
                            dto.getLocation()))
                    .toList();
            useCase.run(commands);
            return ResponseEntity.ok("Dados importados com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Erro: " + e.getMessage());
        }

    }

}
