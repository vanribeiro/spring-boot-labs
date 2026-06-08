package com.uploading.csvfile.domain.strategy;

import java.util.List;

import com.uploading.csvfile.domain.models.ImportReadingCommand;

public interface ImportReadingsStratagy {
    void run(List<ImportReadingCommand> readings);
}
