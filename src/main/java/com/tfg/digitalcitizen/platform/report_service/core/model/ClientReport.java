package com.tfg.digitalcitizen.platform.report_service.core.model;

import java.util.List;

public class ClientReport {

    private final Long clientId;
    private final String clientName;

    private final int totalUsers;
    private final int activeUsers;

    private final int totalLines;
    private final int activeLines;

    private final int totalDevices;

    private final List<String> activeLineNumbers;

    public ClientReport(Long clientId, String clientName, int totalUsers, int activeUsers, int totalLines,
                        int activeLines, int totalDevices, List<String> activeLineNumbers) {

        this.clientId = clientId;
        this.clientName = clientName;
        this.totalUsers = totalUsers;
        this.activeUsers = activeUsers;
        this.totalLines = totalLines;
        this.activeLines = activeLines;
        this.totalDevices = totalDevices;
        this.activeLineNumbers = activeLineNumbers;
    }

    public Long clientId() { return clientId; }
    public String clientName() { return clientName; }
    public int totalUsers() { return totalUsers; }
    public int activeUsers() { return activeUsers; }
    public int totalLines() { return totalLines; }
    public int activeLines() { return activeLines; }
    public int totalDevices() { return totalDevices; }
    public List<String> activeLineNumbers() { return activeLineNumbers; }
}


