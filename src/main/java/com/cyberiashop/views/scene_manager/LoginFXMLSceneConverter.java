package com.cyberiashop.views.scene_manager;

import javafx.scene.Scene;

public class LoginFXMLSceneConverter extends FXMLSceneConverter {
    private final String PATH_TO_LOGIN_FORM_VIEW = "/com/cyberiashop/login-form-view.fxml";

    public Scene convertToScene() throws Exception {
        return getFxmlService().loadFXMLFile(PATH_TO_LOGIN_FORM_VIEW);
    }
}
