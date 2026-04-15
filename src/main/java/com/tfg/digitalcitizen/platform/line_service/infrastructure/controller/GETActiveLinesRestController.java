package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.line_service.application.GETActiveLinesUseCase;
import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import com.tfg.digitalcitizen.platform.line_service.application.mapper.LineMapper;
import com.tfg.digitalcitizen.platform.line_service.application.model.LinesUseCaseResponse;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.controller.dto.LineResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Lines")
@RestController
@RequiredArgsConstructor
public class GETActiveLinesRestController {

    private final GETActiveLinesUseCase useCase;

    @Operation(summary = "Get all active lines")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Active lines retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/lines/active")
    public ResponseEntity<LineResponse> findActive() {

        LinesUseCaseResponse response = useCase.invoke();

        List<LineDto> dtoList = response.getLines().stream()
                .map(LineMapper::toDto)
                .toList();

        return ResponseEntity.ok(
                new LineResponse(dtoList, response.getTotalLines(), response.getTotalLinesFiltered())
        );
    }
}

