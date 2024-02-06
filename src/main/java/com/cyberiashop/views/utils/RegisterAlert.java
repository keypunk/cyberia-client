package com.cyberiashop.views.utils;

import javafx.scene.control.Alert;

public class RegisterAlert {
    private static Alert alert;
    public static void showInvalidRegisterInputAlert() {
        alert = new CyberiaAlert(Alert.AlertType.WARNING);
        alert.setTitle("Empty Fields");
        alert.setHeaderText("Please fill in all the fields");
        alert.setContentText("Both username and password fields are required");
        alert.showAndWait();
    }

    public static void showAccountAlreadyExistsAlert() {
        alert = new CyberiaAlert(Alert.AlertType.ERROR);
        alert.setTitle("Registration failed");
        alert.setHeaderText("Account already exists");
        alert.showAndWait();
    }

    public static void showUnequalPasswordInputAlert() {
        alert = new CyberiaAlert(Alert.AlertType.WARNING);
        alert.setTitle("Registration failed");
        alert.setHeaderText("Passwords are not equal");
        alert.showAndWait();
    }
}
