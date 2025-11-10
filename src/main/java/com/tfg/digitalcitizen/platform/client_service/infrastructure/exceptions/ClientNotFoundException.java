package com.tfg.digitalcitizen.platform.client_service.infrastructure.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}

