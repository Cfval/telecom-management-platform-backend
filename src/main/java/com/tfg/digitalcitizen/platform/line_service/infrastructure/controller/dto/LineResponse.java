package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class LineResponse {
    private final List<LineDto> lines;
    private final Integer totalLines;
    private final Integer totalLinesFiltered;
}
