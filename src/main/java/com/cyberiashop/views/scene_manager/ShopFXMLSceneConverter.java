package com.cyberiashop.views.scene_manager;

import javafx.scene.Scene;

public class ShopFXMLSceneConverter extends FXMLSceneConverter {
    private final String PATH_TO_SHOP_VIEW = "/com/cyberiashop/cyberia-store-main-view.fxml";

    public Scene convertToScene() throws Exception {
        return getFxmlService().loadFXMLFile(PATH_TO_SHOP_VIEW);
    }
}
