package com.tfg.digitalcitizen.platform.user_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.user_service.infrastructure.exceptions.UserNotFoundException;
import com.tfg.digitalcitizen.platform.user_service.infrastructure.exceptions.ErrorSavingUserException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class UserExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleNotFound(UserNotFoundException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleSavingError(ErrorSavingUserException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
