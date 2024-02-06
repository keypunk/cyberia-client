package com.cyberiashop.models.data_models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productCart;
    private static ShoppingCart instance;

    private ShoppingCart() {
        productCart = new ArrayList<>();
    }

    public void addProductToCart(Product product) {
        productCart.add(product);
    }

    public List<Product> getProductCart() {
        return productCart;
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }

        return instance;
    }

    public void clearCart() {
        productCart.clear();
    }
}
