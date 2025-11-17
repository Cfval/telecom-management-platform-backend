package com.tfg.digitalcitizen.platform.report_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class LineUsageReportDto {

    private final Long clientId;
    private final String clientName;

    private final int totalLines;
    private final int activeLines;
    private final int suspendedLines;
    private final int deactivatedLines;

    private final Map<String, Integer> linesByOperator;
    private final int unassignedLines;
}
