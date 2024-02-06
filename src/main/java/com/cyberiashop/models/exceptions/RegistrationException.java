package com.cyberiashop.models.exceptions;

public class RegistrationException extends RuntimeException {
    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
