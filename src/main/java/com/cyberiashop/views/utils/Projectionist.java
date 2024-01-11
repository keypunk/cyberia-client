package com.cyberiashop.views.utils;

import com.cyberiashop.Main;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Projectionist {
    private final String TITLE = "Cyberia";
    private final boolean NOT_RESIZABLE = false;
    private static Projectionist instance;
    private Stage primaryStage;

    private Projectionist() {
        primaryStage = Main.getStage();
        primaryStage.setTitle(TITLE);
        primaryStage.setResizable(NOT_RESIZABLE);

    }

    public static Projectionist getInstance() {
        if (instance == null) {
            instance = new Projectionist();
        }

        return instance;
    }

    public void switchScene(Scene scene) {
        primaryStage.setScene(scene);
    }

    public void showScene() {
        primaryStage.show();
    }
}
