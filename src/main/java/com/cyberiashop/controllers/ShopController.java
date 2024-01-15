package com.cyberiashop.controllers;

import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
public class ShopController {
    private SceneFactory sceneFactory;
    @FXML
    void onMouseClickedLogout(MouseEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }
}
