package com.tfg.digitalcitizen.platform.client_service.application;

import com.tfg.digitalcitizen.platform.client_service.application.model.ClientsUseCaseResponse;
import com.tfg.digitalcitizen.platform.client_service.core.model.Client;
import com.tfg.digitalcitizen.platform.client_service.core.ports.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GETAllClientsUseCase {

    private final ClientRepositoryPort repository;

    public ClientsUseCaseResponse invoke() {

        List<Client> clients = repository.findAll();
        Integer totalClients = clients.size();
        Integer totalClientsFiltered = clients.size(); // TODO: implementar filtros

        return new ClientsUseCaseResponse(clients, totalClients, totalClientsFiltered);
    }
}

