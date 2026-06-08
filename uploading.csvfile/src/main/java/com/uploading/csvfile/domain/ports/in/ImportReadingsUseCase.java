package com.uploading.csvfile.domain.ports.in;

import java.util.List;

import com.uploading.csvfile.domain.models.ImportReadingCommand;

public interface ImportReadingsUseCase {
    void run(List<ImportReadingCommand> readings);
}
