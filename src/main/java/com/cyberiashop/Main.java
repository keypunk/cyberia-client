package com.cyberiashop;

import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        SceneFactory sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }

    public static Stage getStage() {
        return primaryStage;
    }
}
