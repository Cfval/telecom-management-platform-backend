package com.tfg.digitalcitizen.platform.client_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.client_service.application.GETAllClientsUseCase;
import com.tfg.digitalcitizen.platform.client_service.application.dto.ClientDto;
import com.tfg.digitalcitizen.platform.client_service.application.mapper.ClientMapper;
import com.tfg.digitalcitizen.platform.client_service.application.model.ClientsUseCaseResponse;
import com.tfg.digitalcitizen.platform.client_service.infrastructure.controller.dto.ClientsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Tag(name = "Clients")
@RestController
@RequiredArgsConstructor
public class GETAllClientsRestController {

    private final GETAllClientsUseCase useCase;

    @Operation(summary = "Get all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clients found successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = String.class)))
    })
    @GetMapping("/clients")
    public ResponseEntity<ClientsResponse> findAll() {

        ClientsUseCaseResponse clientsList = useCase.invoke();

        List<ClientDto> ClientDtoList = clientsList.getClients().stream()
                .map(ClientMapper::toDto)
                .toList();

        return ResponseEntity.ok(
                new ClientsResponse(ClientDtoList, clientsList.getTotalClients(), clientsList.getTotalClientsFiltered())
        );
    }
}

