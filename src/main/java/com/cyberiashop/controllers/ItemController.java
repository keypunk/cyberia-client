package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.views.utils.Currency;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemController {
    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    private Product product;
    private Currency currency;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void applyDataToView() {
        nameLabel.setText(product.getName());
        priceLabel.setText(product.getPrice() + currency.getCurrency());
        Image image = new Image(getClass().getResourceAsStream(product.getImgSrc()));
        img.setImage(image);
    }
}
