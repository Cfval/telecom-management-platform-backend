package com.tfg.digitalcitizen.platform.client_service.application.model;

import com.tfg.digitalcitizen.platform.client_service.core.model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public final class ClientsUseCaseResponse {
    private final List<Client> clients;
    private final Integer totalClients;
    private final Integer totalClientsFiltered;
}

