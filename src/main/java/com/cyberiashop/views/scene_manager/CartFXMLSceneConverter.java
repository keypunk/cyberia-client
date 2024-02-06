package com.cyberiashop.views.scene_manager;

import javafx.scene.Scene;

public class CartFXMLSceneConverter extends FXMLSceneConverter {
    private final String PATH_TO_CART_VIEW = "/com/cyberiashop/cyberia-store-cart-view.fxml";

    public Scene convertToScene() throws Exception {
        return getFxmlService().loadFXMLFile(PATH_TO_CART_VIEW);
    }
}
