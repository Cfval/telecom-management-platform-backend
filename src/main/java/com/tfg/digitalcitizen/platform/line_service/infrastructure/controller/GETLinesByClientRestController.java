package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.line_service.application.GETLinesByClientIdUseCase;
import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import com.tfg.digitalcitizen.platform.line_service.application.mapper.LineMapper;
import com.tfg.digitalcitizen.platform.line_service.application.model.LinesUseCaseResponse;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.controller.dto.LineResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GETLinesByClientRestController {

    private final GETLinesByClientIdUseCase useCase;

    @Operation(summary = "Get lines filtered by client ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lines found successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid client ID"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/lines/client/{clientId}")
    public ResponseEntity<LineResponse> findByClient(@PathVariable Long clientId) {

        LinesUseCaseResponse response = useCase.invoke(clientId);

        List<LineDto> dtoList = response.getLines().stream()
                .map(LineMapper::toDto)
                .toList();

        return ResponseEntity.ok(
                new LineResponse(dtoList, response.getTotalLines(), response.getTotalLinesFiltered())
        );
    }
}
