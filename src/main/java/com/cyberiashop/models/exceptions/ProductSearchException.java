package com.cyberiashop.models.exceptions;

public class ProductSearchException extends RuntimeException {
    public ProductSearchException(String message, Throwable cause) {
        super(message, cause);
    }
}
