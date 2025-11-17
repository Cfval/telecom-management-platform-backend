package com.tfg.digitalcitizen.platform.report_service.application.model;

import com.tfg.digitalcitizen.platform.report_service.core.model.SystemReport;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SystemReportUseCaseResponse {
    private final SystemReport report;
}
