package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.line_service.application.POSTLineUseCase;
import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.exceptions.ErrorSavingLineException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class POSTLineRestController {

    private final POSTLineUseCase useCase;

    @Operation(summary = "Create new line")
    @PostMapping("/lines")
    public ResponseEntity<LineDto> create(@RequestBody LineDto dto) {

        try {
            LineDto saved = useCase.invoke(dto);
            return ResponseEntity.status(201).body(saved);
        } catch (Exception e) {
            throw new ErrorSavingLineException("Error saving line: " + e.getMessage());
        }
    }
}
