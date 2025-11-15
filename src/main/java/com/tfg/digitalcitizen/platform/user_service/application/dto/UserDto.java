package com.tfg.digitalcitizen.platform.user_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public final class UserDto {

    private final Long id;
    private final String fullName;
    private final String email;
    private final String department;
    private final LocalDate registrationDate;
    private final String status;     // ACTIVE / INACTIVE
    private final String role;
    private final Long clientId;
    private final Long lineId;
}
