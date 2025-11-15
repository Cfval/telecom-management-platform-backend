package com.tfg.digitalcitizen.platform.line_service.application.model;

import com.tfg.digitalcitizen.platform.line_service.core.model.Line;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class LineByIdUseCaseResponse {
    private final Line line;
}
