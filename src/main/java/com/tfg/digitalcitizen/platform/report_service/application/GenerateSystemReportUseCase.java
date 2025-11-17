package com.tfg.digitalcitizen.platform.report_service.application;

import com.tfg.digitalcitizen.platform.report_service.application.model.SystemReportUseCaseResponse;
import com.tfg.digitalcitizen.platform.report_service.core.ports.ReportGeneratorPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenerateSystemReportUseCase {

    private final ReportGeneratorPort generator;

    public SystemReportUseCaseResponse invoke() {
        return new SystemReportUseCaseResponse(generator.generateSystemReport());
    }
}
