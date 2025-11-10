package com.tfg.digitalcitizen.platform.client_service.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public final class ClientDto {
    private final Long id;
    private final String companyName;
    private final String cif;
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final LocalDate registrationDate;
    private final String status;
}

