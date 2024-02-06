package com.cyberiashop.models.business_logic.authentication;

import com.cyberiashop.models.exceptions.AuthenticationException;

import java.rmi.Naming;

public class CustomerAuthenticationFactory implements AuthenticationFactory {
    private final String RESOURCE_NAME = "customerAuthentication";

    public Authentication createAuthentication() {
        try {
            return (Authentication) Naming.lookup(RESOURCE_NAME);
        } catch (Exception ex) {
            throw new AuthenticationException("Authentication service failed", ex);
        }
    }
}
