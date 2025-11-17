package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.report_service.application.dto.LineUsageReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LineUsageReportResponse {
    private final LineUsageReportDto report;
}
