package com.tfg.digitalcitizen.platform.report_service.application;

import com.tfg.digitalcitizen.platform.report_service.application.model.DeviceHealthReportUseCaseResponse;
import com.tfg.digitalcitizen.platform.report_service.core.ports.ReportGeneratorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerateDeviceHealthReportUseCase {

    private final ReportGeneratorPort generator;

    public DeviceHealthReportUseCaseResponse invoke(Long clientId) {
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Client ID must be a positive number");
        }

        return new DeviceHealthReportUseCaseResponse(generator.generateDeviceHealthReport(clientId));
    }
}
