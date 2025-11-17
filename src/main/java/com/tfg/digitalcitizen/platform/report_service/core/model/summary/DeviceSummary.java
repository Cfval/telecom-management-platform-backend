package com.tfg.digitalcitizen.platform.report_service.core.model.summary;

public record DeviceSummary(
        Long id,
        String brand,
        String model,
        String status
) {}
