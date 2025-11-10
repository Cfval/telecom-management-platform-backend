package com.tfg.digitalcitizen.platform.client_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.client_service.application.POSTCreateClientUseCase;
import com.tfg.digitalcitizen.platform.client_service.application.dto.ClientDto;
import com.tfg.digitalcitizen.platform.client_service.infrastructure.exceptions.ErrorSavingClientException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class POSTClientRestController {

    private final POSTCreateClientUseCase useCase;

    @Operation(summary = "Add a new client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/clients")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        try {
            ClientDto savedClient = useCase.invoke(clientDto);
            return ResponseEntity.status(201).body(savedClient);
        } catch (Exception e) {
            throw new ErrorSavingClientException("Error saving client: " + e.getMessage());
        }
    }
}
