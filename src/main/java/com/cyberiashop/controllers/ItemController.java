package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.views.utils.Currency;
import com.cyberiashop.views.utils.DefaultProductImage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.InputStream;

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

        Image image;

        if (product.getImgSrc() != null) {
            image = new Image(getClass().getResourceAsStream(product.getImgSrc()));
        } else {
            image = new Image(getClass().getResourceAsStream(DefaultProductImage.getImagePath()));
        }

        img.setImage(image);
    }

    public Product getProduct() {
        return product;
    }

    public Currency getCurrency() {
        return currency;
    }
}
