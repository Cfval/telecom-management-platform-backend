package com.tfg.digitalcitizen.platform.line_service.infrastructure.exceptions;

public class LineNotFoundException extends RuntimeException {
    public LineNotFoundException(String message) {
        super(message);
    }
}
