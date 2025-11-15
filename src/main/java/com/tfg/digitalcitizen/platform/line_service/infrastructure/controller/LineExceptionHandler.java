package com.tfg.digitalcitizen.platform.line_service.infrastructure.controller;

import com.tfg.digitalcitizen.platform.line_service.infrastructure.exceptions.ErrorSavingLineException;
import com.tfg.digitalcitizen.platform.line_service.infrastructure.exceptions.LineNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class LineExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleNotFound(LineNotFoundException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleSavingError(ErrorSavingLineException ex) {
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
