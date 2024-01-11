package com.cyberiashop.views.scene_manager;


import com.cyberiashop.views.utils.FXMLService;
import javafx.scene.Scene;

public abstract class FXMLSceneConverter {
    private FXMLService fxmlService;

    public FXMLSceneConverter() {
        fxmlService = new FXMLService();
    }

    public FXMLService getFxmlService() {
        return fxmlService;
    }

    public abstract Scene convertToScene() throws Exception;
}
