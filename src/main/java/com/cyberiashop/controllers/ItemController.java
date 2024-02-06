package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.views.utils.Currency;
import com.cyberiashop.views.utils.DefaultProductImage;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
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

    private ShopListener shopListener;

    @FXML
    void onMouseClick(MouseEvent event) {
        shopListener.onClickListener(product);
    }

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

    public void setMyListener(ShopListener shopListener) {
        this.shopListener = shopListener;
    }

    public ShopListener getMyListener() {
        return shopListener;
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
}