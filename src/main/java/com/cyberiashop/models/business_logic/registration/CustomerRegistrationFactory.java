package com.cyberiashop.models.business_logic.registration;

import com.cyberiashop.models.exceptions.RegistrationException;

import java.rmi.Naming;

public class CustomerRegistrationFactory implements RegistrationFactory {
    private final String RESOURCE_NAME = "customerRegistration";

    public Registration createRegistration() {
        try {
            return (Registration) Naming.lookup(RESOURCE_NAME);
        } catch (Exception ex) {
            throw new RegistrationException("Registration service failed", ex);
        }
    }
}
