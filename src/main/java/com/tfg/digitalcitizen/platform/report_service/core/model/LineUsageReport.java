package com.tfg.digitalcitizen.platform.report_service.core.model;

import java.util.Map;

public class LineUsageReport {

    private final Long clientId;
    private final String clientName;

    private final int totalLines;
    private final int activeLines;
    private final int suspendedLines;
    private final int deactivatedLines;

    private final Map<String, Integer> linesByOperator; // Orange, Movistar, etc.
    private final int unassignedLines;

    public LineUsageReport(Long clientId, String clientName, int totalLines, int activeLines, int suspendedLines,
                           int deactivatedLines, Map<String, Integer> linesByOperator, int unassignedLines) {

        this.clientId = clientId;
        this.clientName = clientName;
        this.totalLines = totalLines;
        this.activeLines = activeLines;
        this.suspendedLines = suspendedLines;
        this.deactivatedLines = deactivatedLines;
        this.linesByOperator = linesByOperator;
        this.unassignedLines = unassignedLines;
    }

    public Long clientId() { return clientId; }
    public String clientName() { return clientName; }
    public int totalLines() { return totalLines; }
    public int activeLines() { return activeLines; }
    public int suspendedLines() { return suspendedLines; }
    public int deactivatedLines() { return deactivatedLines; }
    public Map<String, Integer> linesByOperator() { return linesByOperator; }
    public int unassignedLines() { return unassignedLines; }
}

