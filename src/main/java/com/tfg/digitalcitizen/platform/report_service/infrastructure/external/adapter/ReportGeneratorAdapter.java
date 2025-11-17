package com.tfg.digitalcitizen.platform.report_service.infrastructure.external.adapter;

import com.tfg.digitalcitizen.platform.report_service.core.model.*;
import com.tfg.digitalcitizen.platform.report_service.core.model.summary.*;
import com.tfg.digitalcitizen.platform.report_service.core.ports.ExternalDataPort;
import com.tfg.digitalcitizen.platform.report_service.core.ports.ReportGeneratorPort;
import com.tfg.digitalcitizen.platform.shared.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReportGeneratorAdapter implements ReportGeneratorPort {

    private final ExternalDataPort external;

    // ============================================================
    // SYSTEM REPORT
    // ============================================================
    @Override
    public SystemReport generateSystemReport() {

        List<ClientSummary> clients = external.getClients();

        int totalClients = clients.size();
        int totalUsers = clients.stream()
                .mapToInt(c -> external.getUsersByClient(c.id()).size())
                .sum();
        int totalDevices = clients.stream()
                .mapToInt(c -> external.getDevicesByClient(c.id()).size())
                .sum();
        int totalLines = clients.stream()
                .mapToInt(c -> external.getLinesByClient(c.id()).size())
                .sum();

        return new SystemReport(
                "System Overview Report",
                LocalDate.now(),
                totalClients,
                totalUsers,
                totalDevices,
                totalLines
        );
    }

    // ============================================================
    // CLIENT REPORT
    // ============================================================
    @Override
    public ClientReport generateClientReport(Long clientId) {

        ClientSummary client = external.getClients().stream()
                .filter(c -> c.id().equals(clientId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Client not found with ID: " + clientId));

        List<UserSummary> users = external.getUsersByClient(clientId);
        List<DeviceSummary> devices = external.getDevicesByClient(clientId);
        List<LineSummary> lines = external.getLinesByClient(clientId);

        long activeUsers = users.stream().filter(u -> u.status().equalsIgnoreCase("ACTIVE")).count();
        long activeLines = lines.stream().filter(l -> l.status().equalsIgnoreCase("ACTIVE")).count();

        List<String> activeLineNumbers = lines.stream()
                .filter(l -> l.status().equalsIgnoreCase("ACTIVE"))
                .map(LineSummary::phoneNumber)
                .toList();

        return new ClientReport(
                client.id(),
                client.name(),
                users.size(),
                (int) activeUsers,
                lines.size(),
                (int) activeLines,
                devices.size(),
                activeLineNumbers
        );
    }

    // ============================================================
    // DEVICE HEALTH REPORT
    // ============================================================
    @Override
    public DeviceHealthReport generateDeviceHealthReport(Long clientId) {

        ClientSummary client = external.getClients().stream()
                .filter(c -> c.id().equals(clientId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Client not found with ID: " + clientId));

        List<DeviceSummary> devices = external.getDevicesByClient(clientId);

        int total = devices.size();

        int assigned = countStatus(devices, "ASSIGNED");
        int storage = countStatus(devices, "STORAGE");
        int repair = countStatus(devices, "REPAIR");
        int lost = countStatus(devices, "LOST");
        int decom = countStatus(devices, "DECOMMISSIONED");

        return new DeviceHealthReport(
                client.id(),
                client.name(),
                total,
                assigned,
                storage,
                repair,
                lost,
                decom
        );
    }

    private int countStatus(List<DeviceSummary> list, String status) {
        return (int) list.stream()
                .filter(d -> d.status().equalsIgnoreCase(status))
                .count();
    }

    // ============================================================
    // LINE USAGE REPORT
    // ============================================================
    @Override
    public LineUsageReport generateLineUsageReport(Long clientId) {

        ClientSummary client = external.getClients().stream()
                .filter(c -> c.id().equals(clientId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Client not found with ID: " + clientId));

        List<LineSummary> lines = external.getLinesByClient(clientId);

        int total = lines.size();

        int active = countLineStatus(lines, "ACTIVE");
        int suspended = countLineStatus(lines, "SUSPENDED");
        int deactivated = countLineStatus(lines, "DEACTIVATED");

        // LÍNEAS POR OPERADOR
        Map<String, Integer> linesByOperator =
                lines.stream()
                        .collect(Collectors.groupingBy(
                                l -> l.operator() != null ? l.operator() : "UNKNOWN",
                                Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                        ));

        // LÍNEAS NO ASIGNADAS
        int unassigned =
                (int) lines.stream()
                        .filter(l -> l.employeeId() == null)
                        .count();

        return new LineUsageReport(
                client.id(),
                client.name(),
                total,
                active,
                suspended,
                deactivated,
                linesByOperator,
                unassigned
        );
    }

    private int countLineStatus(List<LineSummary> list, String status) {
        return (int) list.stream()
                .filter(l -> l.status().equalsIgnoreCase(status))
                .count();
    }

    // ============================================================
    // NO NECESARIO PERO LO REQUIERE LA INTERFAZ
    // ============================================================
    @Override
    public List<ClientReport> generateAllClientReports() {
        return external.getClients().stream()
                .map(c -> generateClientReport(c.id()))
                .toList();
    }
}
