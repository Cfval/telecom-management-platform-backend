package com.tfg.digitalcitizen.platform.report_service.core.model;

import java.time.LocalDate;

public class ReportData {

    private final String reportName;
    private final LocalDate generatedAt;
    private final int totalClients;
    private final int totalUsers;
    private final int totalDevices;
    private final int totalLines;

    public ReportData(String reportName, LocalDate generatedAt, int totalClients, int totalUsers,
                      int totalDevices, int totalLines) {
        this.reportName = reportName;
        this.generatedAt = generatedAt;
        this.totalClients = totalClients;
        this.totalUsers = totalUsers;
        this.totalDevices = totalDevices;
        this.totalLines = totalLines;
    }

    public String reportName() { return reportName; }
    public LocalDate generatedAt() { return generatedAt; }
    public int totalClients() { return totalClients; }
    public int totalUsers() { return totalUsers; }
    public int totalDevices() { return totalDevices; }
    public int totalLines() { return totalLines; }
}
