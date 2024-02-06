package com.cyberiashop.models.business_logic.management_logic;

import com.cyberiashop.models.exceptions.ProductManagerException;

import java.rmi.Naming;

public class ElectronicProductManagerFactory implements ProductManagerFactory {
    private final String RESOURCE_NAME = "electronicProductManager";

    public ProductManager createProductManager() {
        try {
            return (ProductManager) Naming.lookup(RESOURCE_NAME);
        } catch (Exception ex) {
            throw new ProductManagerException("Product manager service failed", ex);
        }
    }
}
