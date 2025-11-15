package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LineByIdResponse {
    private final LineDto line;
}
