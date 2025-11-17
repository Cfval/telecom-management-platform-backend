package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.report_service.application.dto.SystemReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SystemReportResponse {
    private final SystemReportDto report;
}
