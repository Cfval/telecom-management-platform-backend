package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.line_service.application.PUTLineUseCase;
import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.exceptions.ErrorSavingLineException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PUTLineRestController {

    private final PUTLineUseCase useCase;

    @Operation(summary = "Update line")
    @PutMapping("/lines/{id}")
    public ResponseEntity<LineDto> update(@PathVariable Long id, @RequestBody LineDto dto) {

        try {
            LineDto updated = useCase.invoke(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            throw new ErrorSavingLineException("Error updating line: " + e.getMessage());
        }
    }
}
