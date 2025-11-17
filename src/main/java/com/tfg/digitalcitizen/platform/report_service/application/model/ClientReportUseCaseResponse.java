package com.tfg.digitalcitizen.platform.report_service.application.model;

import com.tfg.digitalcitizen.platform.report_service.core.model.ClientReport;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientReportUseCaseResponse {
    private final ClientReport report;
}
