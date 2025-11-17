package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.report_service.application.GenerateClientReportUseCase;
import com.tfg.digitalcitizen.platform.report_service.application.mapper.ReportMapper;
import com.tfg.digitalcitizen.platform.report_service.application.model.ClientReportUseCaseResponse;
import com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto.ClientReportResponse;
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
public class GETClientReportRestController {

    private final GenerateClientReportUseCase useCase;

    @Operation(summary = "Generate detailed report for a client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client report generated successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/reports/client/{clientId}")
    public ResponseEntity<ClientReportResponse> getClientReport(@PathVariable Long clientId) {

        ClientReportUseCaseResponse response = useCase.invoke(clientId);

        return ResponseEntity.ok(
                new ClientReportResponse(
                        ReportMapper.toDto(response.getReport())
                )
        );
    }
}

