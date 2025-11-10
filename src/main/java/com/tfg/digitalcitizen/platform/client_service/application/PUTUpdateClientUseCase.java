package com.tfg.digitalcitizen.platform.client_service.application;

import com.tfg.digitalcitizen.platform.client_service.application.dto.ClientDto;
import com.tfg.digitalcitizen.platform.client_service.application.mapper.ClientMapper;
import com.tfg.digitalcitizen.platform.client_service.core.model.Client;
import com.tfg.digitalcitizen.platform.client_service.core.ports.ClientRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PUTUpdateClientUseCase {

    private final ClientRepositoryPort repository;

    public ClientDto invoke(ClientDto clientDto) {
        if (clientDto == null || clientDto.getId() == null) {
            throw new IllegalArgumentException("Client or client ID cannot be null");
        }

        Client clientToUpdate = ClientMapper.toDomain(clientDto);
        Client updatedClient = repository.update(clientToUpdate);
        return ClientMapper.toDto(updatedClient);
    }
}

