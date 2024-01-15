package com.cyberiashop.views.scene_manager;

public class ShopSceneFactory extends SceneFactory {
    public FXMLSceneConverter createFXMLSceneConverter() throws Exception {
        return new ShopFXMLSceneConverter();
    }
}
