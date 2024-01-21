package com.cyberiashop.models.business_logic.shop_logic;

import com.cyberiashop.models.exceptions.ProductSearchException;

import java.rmi.Naming;

public class ElectronicProductSearchFactory implements ProductSearchFactory {
    private final String RESOURCE_NAME = "electronicProductSearch";

    public ProductSearch createProductSearch() {
        try {
            return (ProductSearch) Naming.lookup(RESOURCE_NAME);
        } catch (Exception ex) {
            throw new ProductSearchException("Product search service failed", ex.getCause());
        }
    }
}
