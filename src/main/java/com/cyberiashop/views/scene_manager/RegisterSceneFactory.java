package com.cyberiashop.views.scene_manager;

public class RegisterSceneFactory extends SceneFactory {
    public FXMLSceneConverter createFXMLSceneConverter() throws Exception {
        return new RegisterFXMLSceneConverter();
    }
}
