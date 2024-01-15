package com.cyberiashop.models.utils;

import com.cyberiashop.views.utils.CyberiaAlert;
import javafx.scene.control.Alert;

public class LoginAlerts {
    private static Alert alert;
    public static void showInvalidLoginInputAlert() {
        alert = new CyberiaAlert(Alert.AlertType.WARNING);
        alert.setTitle("Empty Fields");
        alert.setHeaderText("Please fill in all the fields");
        alert.setContentText("Both username and password fields are required");
        alert.showAndWait();
    }

    public static void showFailedLoginAlert() {
        alert = new CyberiaAlert(Alert.AlertType.ERROR);
        alert.setTitle("Authentication failed");
        alert.setHeaderText("Account not found");
        alert.showAndWait();
    }
}
