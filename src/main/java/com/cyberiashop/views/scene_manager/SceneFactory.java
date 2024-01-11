package com.cyberiashop.views.scene_manager;


import com.cyberiashop.views.utils.Projectionist;
import javafx.scene.Scene;

public abstract class SceneFactory {
    private Projectionist projectionist = Projectionist.getInstance();
    public void renderScene() throws Exception {
        Scene scene = createFXMLSceneConverter().convertToScene();
        projectionist.switchScene(scene);
        projectionist.showScene();
    }

    public abstract FXMLSceneConverter createFXMLSceneConverter() throws Exception;
}
