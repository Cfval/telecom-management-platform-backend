package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.user_service.application.PUTUserUseCase;
import com.tfg.digitalcitizen.platform.user_service.application.dto.UserDto;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.exceptions.ErrorSavingUserException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PUTUserRestController {

    private final PUTUserUseCase useCase;

    @PutMapping("/users/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto dto) {

        try {
            UserDto updated = useCase.invoke(id, dto);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            throw new ErrorSavingUserException("Error updating user: " + e.getMessage());
        }
    }
}

