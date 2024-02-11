package com.cyberiashop.views.scene_manager;

import javafx.scene.Scene;

public class EmployeeManagementFXMLSceneConverter extends FXMLSceneConverter {
    private final String PATH_TO_EMPLOYEE_MANAGEMENT_VIEW = "/com/cyberiashop/" +
            "cyberia-store-employee-management-view.fxml";

    public Scene convertToScene() throws Exception {
        return getFxmlService().loadFXMLFile(PATH_TO_EMPLOYEE_MANAGEMENT_VIEW);
    }
}
