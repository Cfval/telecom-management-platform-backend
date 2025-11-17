package com.tfg.digitalcitizen.platform.report_service.infrastructure.external.adapter;

import com.tfg.digitalcitizen.platform.report_service.core.model.summary.*;
import com.tfg.digitalcitizen.platform.report_service.core.ports.ExternalDataPort;
import com.tfg.digitalcitizen.platform.report_service.infrastructure.external.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.tfg.digitalcitizen.platform.report_service.infrastructure.external.util.MapUtils.*;

@Component
@RequiredArgsConstructor
public class ExternalDataAdapter implements ExternalDataPort {

    private final ClientFeignClient clientClient;
    private final UserFeignClient userClient;
    private final DeviceFeignClient deviceClient;
    private final LineFeignClient lineClient;

    // ============================================================
    // CLIENTS
    // ============================================================

    @Override
    public List<ClientSummary> getClients() {

        Map<String,Object> raw = clientClient.getAllClients();

        List<Map<String,Object>> items = list(raw.get("clientsList"));

        return items.stream()
                .map(m -> new ClientSummary(
                        num(m.get("id")),
                        str(m.get("companyName"))
                ))
                .toList();
    }

    // ============================================================
    // USERS
    // ============================================================

    @Override
    public List<UserSummary> getUsersByClient(Long clientId) {

        Map<String,Object> raw = userClient.getUsersByClient(clientId);

        List<Map<String,Object>> items = list(raw.get("users"));

        return items.stream()
                .map(m -> new UserSummary(
                        num(m.get("id")),
                        str(m.get("email")),
                        str(m.get("status"))
                ))
                .toList();
    }

    // ============================================================
    // DEVICES
    // ============================================================

    @Override
    public List<DeviceSummary> getDevicesByClient(Long clientId) {

        Map<String,Object> raw = deviceClient.getDevicesByClient(clientId);

        List<Map<String,Object>> items = list(raw.get("devices"));

        return items.stream()
                .map(m -> new DeviceSummary(
                        num(m.get("id")),
                        str(m.get("brand")),
                        str(m.get("model")),
                        str(m.get("status"))
                ))
                .toList();
    }

    // ============================================================
    // LINES
    // ============================================================

    @Override
    public List<LineSummary> getLinesByClient(Long clientId) {

        Map<String, Object> raw = lineClient.getLinesByClient(clientId);

        List<Map<String, Object>> items = list(raw.get("lines"));

        return items.stream()
                .map(m -> new LineSummary(
                        num(m.get("id")),
                        str(m.get("phoneNumber")),
                        str(m.get("status")),
                        str(m.get("operator")),
                        num(m.get("employeeId")),
                        num(m.get("deviceId"))
                ))
                .toList();
    }
}



