package com.tfg.digitalcitizen.platform.report_service.application.model;

import com.tfg.digitalcitizen.platform.report_service.core.model.LineUsageReport;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LineUsageReportUseCaseResponse {
    private final LineUsageReport report;
}
