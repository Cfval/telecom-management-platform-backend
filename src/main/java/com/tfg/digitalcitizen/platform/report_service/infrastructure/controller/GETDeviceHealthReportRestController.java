package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.report_service.application.GenerateDeviceHealthReportUseCase;
import com.tfg.digitalcitizen.platform.report_service.application.mapper.ReportMapper;
import com.tfg.digitalcitizen.platform.report_service.application.model.DeviceHealthReportUseCaseResponse;
import com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto.DeviceHealthReportResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GETDeviceHealthReportRestController {

    private final GenerateDeviceHealthReportUseCase useCase;

    @Operation(summary = "Generate device health report for a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Device health report generated successfully"),
            @ApiResponse(responseCode = "404", description = "Client or devices not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/reports/client/{clientId}/devices")
    public ResponseEntity<DeviceHealthReportResponse> getDeviceHealthReport(@PathVariable Long clientId) {

        DeviceHealthReportUseCaseResponse response = useCase.invoke(clientId);

        return ResponseEntity.ok(
                new DeviceHealthReportResponse(
                        ReportMapper.toDto(response.getReport())
                )
        );
    }
}
