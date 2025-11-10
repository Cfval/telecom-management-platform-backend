package com.tfg.digitalcitizen.platform.client_service.infrastructure.controller.dto;

import com.tfg.digitalcitizen.platform.client_service.application.dto.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class ClientsResponse {
    private final List<ClientDto> clientsList;
    private final Integer totalClients;
    private final Integer totalClientsFiltered;
}

