package com.tfg.digitalcitizen.platform.report_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.report_service.application.dto.DeviceHealthReportDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceHealthReportResponse {
    private final DeviceHealthReportDto report;
}
