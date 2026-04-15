package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.report_service.application.GenerateLineUsageReportUseCase;
import com.tfg.digitalcitizen.platform.report_service.application.mapper.ReportMapper;
import com.tfg.digitalcitizen.platform.report_service.application.model.LineUsageReportUseCaseResponse;
import com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto.LineUsageReportResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Reports")
@RestController
@RequiredArgsConstructor
public class GETLineUsageReportRestController {

    private final GenerateLineUsageReportUseCase useCase;

    @Operation(summary = "Generate line usage report for a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Line usage report generated successfully"),
            @ApiResponse(responseCode = "404", description = "Client or lines not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/reports/client/{clientId}/lines")
    public ResponseEntity<LineUsageReportResponse> getLineUsageReport(@PathVariable Long clientId) {

        LineUsageReportUseCaseResponse response = useCase.invoke(clientId);

        return ResponseEntity.ok(
                new LineUsageReportResponse(
                        ReportMapper.toDto(response.getReport())
                )
        );
    }
}
