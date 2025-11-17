package com.tfg.digitalcitizen.platform.report_service.application.mapper;

import com.tfg.digitalcitizen.platform.report_service.application.dto.*;
import com.tfg.digitalcitizen.platform.report_service.core.model.*;

public final class ReportMapper {

    private ReportMapper() {}

    public static SystemReportDto toDto(SystemReport report) {
        return new SystemReportDto(
                report.reportName(),
                report.generatedAt(),
                report.totalClients(),
                report.totalUsers(),
                report.totalDevices(),
                report.totalLines()
        );
    }

    public static ClientReportDto toDto(ClientReport report) {
        return new ClientReportDto(
                report.clientId(),
                report.clientName(),
                report.totalUsers(),
                report.activeUsers(),
                report.totalLines(),
                report.activeLines(),
                report.totalDevices(),
                report.activeLineNumbers()
        );
    }

    public static DeviceHealthReportDto toDto(DeviceHealthReport report) {
        return new DeviceHealthReportDto(
                report.clientId(),
                report.clientName(),
                report.totalDevices(),
                report.assignedDevices(),
                report.storageDevices(),
                report.repairDevices(),
                report.lostDevices(),
                report.decommissionedDevices()
        );
    }

    public static LineUsageReportDto toDto(LineUsageReport report) {
        return new LineUsageReportDto(
                report.clientId(),
                report.clientName(),
                report.totalLines(),
                report.activeLines(),
                report.suspendedLines(),
                report.deactivatedLines(),
                report.linesByOperator(),
                report.unassignedLines()
        );
    }
}
