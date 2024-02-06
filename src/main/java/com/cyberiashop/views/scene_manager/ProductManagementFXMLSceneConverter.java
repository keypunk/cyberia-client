package com.cyberiashop.views.scene_manager;

import javafx.scene.Scene;

public class ProductManagementFXMLSceneConverter extends FXMLSceneConverter {
    private final String PATH_TO_PRODUCT_MANAGEMENT_VIEW = "/com/cyberiashop/cyberia-store-product-management-view.fxml";

    public Scene convertToScene() throws Exception {
        return getFxmlService().loadFXMLFile(PATH_TO_PRODUCT_MANAGEMENT_VIEW);
    }
}
