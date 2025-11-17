package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.report_service.application.dto.ClientReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientReportResponse {
    private final ClientReportDto report;
}
