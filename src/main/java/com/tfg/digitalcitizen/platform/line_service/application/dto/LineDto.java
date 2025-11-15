package com.tfg.digitalcitizen.platform.line_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public final class LineDto {

    private final Long id;
    private final String phoneNumber;
    private final String tariffType;
    private final LocalDate activationDate;

    // Campos de la SIMCard
    private final String iccid;
    private final String simType;
    private final String pin;
    private final String puk;
    private final String operator;

    private final String status;

    private final Long clientId;
    private final Long employeeId;
    private final Long deviceId;
}
