package com.tfg.digitalcitizen.platform.line_service.application.model;

import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public final class LinesUseCaseResponse {
    private final List<Line> lines;
    private final Integer totalLines;
    private final Integer totalLinesFiltered;
}
