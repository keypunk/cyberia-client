package com.cyberiashop.views.utils;

import com.cyberiashop.Client;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class FXMLService {
    private FXMLLoader fxmlLoader;

    public Scene loadFXMLFile(String fxmlFilePath) throws Exception {
        fxmlLoader = new FXMLLoader(Client.class.getResource(fxmlFilePath));
        Scene scene = new Scene(fxmlLoader.load());
        return scene;
    }

}
