package com.tfg.digitalcitizen.platform.client_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.client_service.application.dto.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientByIdResponse {
    private final ClientDto client;
}

