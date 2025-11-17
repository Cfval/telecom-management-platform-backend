package com.tfg.digitalcitizen.platform.report_service.core.model;

public class DeviceHealthReport {

    private final Long clientId;
    private final String clientName;

    private final int totalDevices;

    private final int assignedDevices;
    private final int storageDevices;
    private final int repairDevices;
    private final int lostDevices;
    private final int decommissionedDevices;

    public DeviceHealthReport(Long clientId, String clientName, int totalDevices, int assignedDevices,
                              int storageDevices, int repairDevices, int lostDevices, int decommissionedDevices) {

        this.clientId = clientId;
        this.clientName = clientName;
        this.totalDevices = totalDevices;
        this.assignedDevices = assignedDevices;
        this.storageDevices = storageDevices;
        this.repairDevices = repairDevices;
        this.lostDevices = lostDevices;
        this.decommissionedDevices = decommissionedDevices;
    }

    public Long clientId() { return clientId; }
    public String clientName() { return clientName; }
    public int totalDevices() { return totalDevices; }
    public int assignedDevices() { return assignedDevices; }
    public int storageDevices() { return storageDevices; }
    public int repairDevices() { return repairDevices; }
    public int lostDevices() { return lostDevices; }
    public int decommissionedDevices() { return decommissionedDevices; }
}
