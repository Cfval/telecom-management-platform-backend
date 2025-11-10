package com.tfg.digitalcitizen.platform.report_service.core.ports;

import com.tfg.digitalcitizen.platform.report_service.core.model.ReportData;
import com.tfg.digitalcitizen.platform.report_service.core.model.ClientReport;
import java.util.List;

public interface ReportGeneratorPort {

    // Informe general del sistema
    ReportData generateSystemReport();

    // Informe detallado por cliente
    ClientReport generateClientReport(Long clientId);

    // Informe agregado de todos los clientes
    List<ClientReport> generateAllClientReports();
}

