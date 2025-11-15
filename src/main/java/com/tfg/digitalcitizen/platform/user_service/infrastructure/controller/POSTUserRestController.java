package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.user_service.application.POSTUserUseCase;
import com.tfg.digitalcitizen.platform.user_service.application.dto.UserDto;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.exceptions.ErrorSavingUserException;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class POSTUserRestController {

    private final POSTUserUseCase useCase;

    @PostMapping("/users")
    public ResponseEntity<UserDto> create(@RequestBody UserDto dto) {

        try {
            UserDto saved = useCase.invoke(dto);
            return ResponseEntity.status(201).body(saved);
        } catch (Exception e) {
            throw new ErrorSavingUserException("Error saving user: " + e.getMessage());
        }
    }
}
