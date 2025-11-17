package com.tfg.digitalcitizen.platform.report_service.core.ports;

import com.tfg.digitalcitizen.platform.report_service.core.model.summary.*;

import java.util.List;

public interface ExternalDataPort {

    List<ClientSummary> getClients();

    List<UserSummary> getUsersByClient(Long clientId);

    List<DeviceSummary> getDevicesByClient(Long clientId);

    List<LineSummary> getLinesByClient(Long clientId);
}


