package com.cyberiashop.models.exceptions;

public class UserSearchException extends RuntimeException {
    public UserSearchException(String message, Throwable ex) {
        super(message, ex);
    }
}
