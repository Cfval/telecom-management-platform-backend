package com.tfg.digitalcitizen.platform.report_service.application.model;

import com.tfg.digitalcitizen.platform.report_service.core.model.DeviceHealthReport;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceHealthReportUseCaseResponse {
    private final DeviceHealthReport report;
}
