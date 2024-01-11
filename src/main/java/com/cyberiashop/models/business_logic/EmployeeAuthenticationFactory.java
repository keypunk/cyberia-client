package com.cyberiashop.models.business_logic;

import com.cyberiashop.models.exceptions.AuthenticationException;

import java.rmi.Naming;

public class EmployeeAuthenticationFactory implements AuthenticationFactory {
    private final String RESOURCE_NAME = "employeeAuthentication";

    public Authentication createAuthentication() {
         try {
             return (Authentication) Naming.lookup(RESOURCE_NAME);
         } catch (Exception ex) {
             throw new AuthenticationException("Authentication service failed", ex);
         }
    }
}
