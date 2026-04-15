package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.report_service.application.GenerateSystemReportUseCase;
import com.tfg.digitalcitizen.platform.report_service.application.mapper.ReportMapper;
import com.tfg.digitalcitizen.platform.report_service.application.model.SystemReportUseCaseResponse;
import com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto.SystemReportResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reports")
@RestController
@RequiredArgsConstructor
public class GETSystemReportRestController {

    private final GenerateSystemReportUseCase useCase;

    @Operation(summary = "Generate system-wide report")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "System report generated successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/reports/system")
    public ResponseEntity<SystemReportResponse> getSystemReport() {

        SystemReportUseCaseResponse response = useCase.invoke();

        return ResponseEntity.ok(
                new SystemReportResponse(
                        ReportMapper.toDto(response.getReport())
                )
        );
    }
}
