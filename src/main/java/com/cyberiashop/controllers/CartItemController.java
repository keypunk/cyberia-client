package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.views.utils.Currency;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CartItemController {
    @FXML
    private Label productNameLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label quantityLabel;

    private Product product;
    private Currency currency;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void applyDataToView() {
        productNameLabel.setText(product.getName());
        quantityLabel.setText("Amount: " + product.getQuantity());
        priceLabel.setText(product.getPrice() + currency.getCurrency());
    }
}
