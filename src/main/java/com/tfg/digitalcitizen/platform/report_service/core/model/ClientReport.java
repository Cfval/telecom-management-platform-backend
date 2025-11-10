package com.tfg.digitalcitizen.platform.report_service.core.model;

import java.util.List;

public class ClientReport {

    private final Long clientId;
    private final String clientName;
    private final int totalUsers;
    private final int totalLines;
    private final int totalDevices;
    private final List<String> activeLineNumbers;

    public ClientReport(Long clientId, String clientName, int totalUsers,
                        int totalLines, int totalDevices, List<String> activeLineNumbers) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.totalUsers = totalUsers;
        this.totalLines = totalLines;
        this.totalDevices = totalDevices;
        this.activeLineNumbers = activeLineNumbers;
    }

    public Long clientId() { return clientId; }
    public String clientName() { return clientName; }
    public int totalUsers() { return totalUsers; }
    public int totalLines() { return totalLines; }
    public int totalDevices() { return totalDevices; }
    public List<String> activeLineNumbers() { return activeLineNumbers; }
}

