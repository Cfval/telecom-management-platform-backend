package com.tfg.digitalcitizen.platform.user_service.infrastructure.exceptions;

public class ErrorSavingUserException extends RuntimeException {
    public ErrorSavingUserException(String message) {
        super(message);
    }
}
