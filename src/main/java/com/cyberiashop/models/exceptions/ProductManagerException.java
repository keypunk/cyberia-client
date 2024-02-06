package com.cyberiashop.models.exceptions;

public class ProductManagerException extends RuntimeException {
    public ProductManagerException(String message, Throwable cause) {
        super(message, cause);
    }
}
