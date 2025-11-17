package com.tfg.digitalcitizen.platform.report_service.application;

import com.tfg.digitalcitizen.platform.report_service.application.model.ClientReportUseCaseResponse;
import com.tfg.digitalcitizen.platform.report_service.core.ports.ReportGeneratorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerateClientReportUseCase {

    private final ReportGeneratorPort generator;

    public ClientReportUseCaseResponse invoke(Long clientId) {
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("Client ID must be a positive number");
        }

        return new ClientReportUseCaseResponse(generator.generateClientReport(clientId));
    }
}
