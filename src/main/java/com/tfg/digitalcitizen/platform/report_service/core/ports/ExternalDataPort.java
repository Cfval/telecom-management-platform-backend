package com.tfg.digitalcitizen.platform.report_service.core.ports;

import java.util.List;
import java.util.Map;

public interface ExternalDataPort {

    // Consultar resumen de clientes
    List<Map<String, Object>> getClientsSummary();

    // Consultar líneas activas por cliente
    List<Map<String, Object>> getActiveLinesByClient(Long clientId);

    // Consultar dispositivos por cliente
    List<Map<String, Object>> getDevicesByClient(Long clientId);

    // Consultar empleados activos por cliente
    List<Map<String, Object>> getUsersByClient(Long clientId);
}

