package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.user_service.application.DELETEUserUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DELETEUserRestController {

    private final DELETEUserUseCase useCase;

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        useCase.invoke(id);
        return ResponseEntity.noContent().build();
    }
}
