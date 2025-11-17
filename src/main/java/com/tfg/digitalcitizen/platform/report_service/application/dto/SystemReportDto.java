package com.tfg.digitalcitizen.platform.report_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class SystemReportDto {

    private final String reportName;
    private final LocalDate generatedAt;

    private final int totalClients;
    private final int totalUsers;
    private final int totalDevices;
    private final int totalLines;
}
