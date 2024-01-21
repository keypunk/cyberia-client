package com.cyberiashop.views.utils;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class ShopDimensions {
    private GridPane gridpane;

    public ShopDimensions(GridPane gridpane) {
        this.gridpane = gridpane;
    }

    public void applyDimensions() {
        // set grid width for shop
        gridpane.setMinWidth(Region.USE_COMPUTED_SIZE);
        gridpane.setPrefWidth(Region.USE_COMPUTED_SIZE);
        gridpane.setMaxWidth(Region.USE_PREF_SIZE);

        // set grid height
        gridpane.setMinHeight(Region.USE_COMPUTED_SIZE);
        gridpane.setPrefHeight(Region.USE_COMPUTED_SIZE);
        gridpane.setMaxWidth(Region.USE_PREF_SIZE);
    }
}
