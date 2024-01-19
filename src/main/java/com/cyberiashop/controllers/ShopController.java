package com.cyberiashop.controllers;

import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
public class ShopController {
    private SceneFactory sceneFactory;

    @FXML
    void handleLogoutAction(ActionEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }
}
