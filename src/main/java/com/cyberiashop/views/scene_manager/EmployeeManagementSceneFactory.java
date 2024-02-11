package com.cyberiashop.views.scene_manager;

public class EmployeeManagementSceneFactory extends SceneFactory {
    public FXMLSceneConverter createFXMLSceneConverter() throws Exception {
        return new EmployeeManagementFXMLSceneConverter();
    }
}
