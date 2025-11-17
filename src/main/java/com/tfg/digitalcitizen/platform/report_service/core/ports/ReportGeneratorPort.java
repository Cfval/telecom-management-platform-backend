package com.tfg.digitalcitizen.platform.report_service.core.ports;

import com.tfg.digitalcitizen.platform.report_service.core.model.*;

import java.util.List;

public interface ReportGeneratorPort {

    SystemReport generateSystemReport();

    ClientReport generateClientReport(Long clientId);

    List<ClientReport> generateAllClientReports();

    // reportes específicos para un cliente
    DeviceHealthReport generateDeviceHealthReport(Long clientId);

    LineUsageReport generateLineUsageReport(Long clientId);
}



