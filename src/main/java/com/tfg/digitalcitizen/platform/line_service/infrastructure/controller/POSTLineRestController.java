package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.line_service.application.POSTLineUseCase;
import com.tfg.digitalcitizen.platform.line_service.application.dto.LineDto;
import com.tfg.digitalcitizen.platform.shared.api.ApiSuccessResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Lines")
@RestController
@RequiredArgsConstructor
public class POSTLineRestController {

    private final POSTLineUseCase useCase;

    @Operation(summary = "Create a new mobile line")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Line created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid line data")
    })
    @PostMapping("/lines")
    public ResponseEntity<ApiSuccessResponse<LineDto>> create(@Valid @RequestBody LineDto dto, HttpServletRequest request) {

        LineDto saved = useCase.invoke(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiSuccessResponse.of(saved, 201, request.getRequestURI()));
    }
}
