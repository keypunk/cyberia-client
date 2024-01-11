package com.cyberiashop.views.utils;

import com.cyberiashop.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class FXMLService {
    private FXMLLoader fxmlLoader;

    public Scene loadFXMLFile(String fxmlFilePath) throws Exception {
        fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFilePath));
        Scene scene = new Scene(fxmlLoader.load());
        return scene;
    }

}
