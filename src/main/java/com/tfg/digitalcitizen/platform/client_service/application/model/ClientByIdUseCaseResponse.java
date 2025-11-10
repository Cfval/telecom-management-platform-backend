package com.tfg.digitalcitizen.platform.client_service.application.model;

import com.tfg.digitalcitizen.platform.client_service.core.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class ClientByIdUseCaseResponse {
    private final Client client;
}

