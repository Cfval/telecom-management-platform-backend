package com.tfg.digitalcitizen.platform.report_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ClientReportDto {

    private final Long clientId;
    private final String clientName;

    private final int totalUsers;
    private final int activeUsers;

    private final int totalLines;
    private final int activeLines;

    private final int totalDevices;

    private final List<String> activeLineNumbers;
}
