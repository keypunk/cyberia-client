package com.cyberiashop.views.scene_manager;

import javafx.scene.Scene;

public class RegisterFXMLSceneConverter extends FXMLSceneConverter {
    private final String PATH_TO_REGISTER_VIEW = "/com/cyberiashop/register-form-view.fxml";

    public Scene convertToScene() throws Exception {
        return getFxmlService().loadFXMLFile(PATH_TO_REGISTER_VIEW);
    }
}
