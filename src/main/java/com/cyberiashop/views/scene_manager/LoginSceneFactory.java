package com.cyberiashop.views.scene_manager;


public class LoginSceneFactory extends SceneFactory {

    public FXMLSceneConverter createFXMLSceneConverter() throws Exception {
        return new LoginFXMLSceneConverter();
    }
}
