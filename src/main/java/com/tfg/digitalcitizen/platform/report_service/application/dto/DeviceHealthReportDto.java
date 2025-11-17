package com.tfg.digitalcitizen.platform.report_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceHealthReportDto {

    private final Long clientId;
    private final String clientName;

    private final int totalDevices;
    private final int assignedDevices;
    private final int storageDevices;
    private final int repairDevices;
    private final int lostDevices;
    private final int decommissionedDevices;
}
