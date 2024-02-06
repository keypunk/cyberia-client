package com.cyberiashop.views.scene_manager;

public class ProductManagementSceneFactory extends SceneFactory {
    public FXMLSceneConverter createFXMLSceneConverter() throws Exception {
        return new ProductManagementFXMLSceneConverter();
    }
}
