package com.tfg.digitalcitizen.platform.client_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.client_service.application.DELETEClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DELETEClientRestController {

    private final DELETEClientUseCase useCase;

    @Operation(summary = "Delete a client by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Long> deleteClient(@PathVariable Long id) {
        Long deletedId = useCase.invoke(id);
        return ResponseEntity.ok(deletedId);
    }
}

