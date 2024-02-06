package com.cyberiashop.views.scene_manager;

public class CartSceneFactory extends SceneFactory {
    public FXMLSceneConverter createFXMLSceneConverter() throws Exception {
        return new CartFXMLSceneConverter();
    }
}
