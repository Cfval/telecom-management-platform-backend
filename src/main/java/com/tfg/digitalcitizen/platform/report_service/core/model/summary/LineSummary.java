package com.tfg.digitalcitizen.platform.report_service.core.model.summary;

public record LineSummary(
        Long id,
        String phoneNumber,
        String status,
        String operator,
        Long employeeId,
        Long deviceId
) {}

