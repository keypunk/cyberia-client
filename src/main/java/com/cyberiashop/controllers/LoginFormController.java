package com.cyberiashop.controllers;

import com.cyberiashop.models.utils.EmptyInputValidator;
import com.cyberiashop.models.business_logic.Authentication;
import com.cyberiashop.models.business_logic.EmployeeAuthenticationFactory;
import com.cyberiashop.views.utils.CyberiaAlert;
import com.cyberiashop.views.scene_manager.SceneFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfUsername;
    @FXML
    private ComboBox<String> cbUserroles;
    private final String EMPLOYEE_ROLE = "Employee";
    private final String CUSTOMER_ROLE = "Customer";
    private final String[] USER_ROLES = { EMPLOYEE_ROLE, CUSTOMER_ROLE };
    private Authentication authentication;
    private SceneFactory sceneFactory;
    private EmptyInputValidator validator;
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        cbUserroles.getItems().addAll(USER_ROLES);
        // select first option in combobox as default otherwise the combobox would select an "empty" string
        cbUserroles.getSelectionModel().select(0);
    }

    @FXML
    void handleLoginAction(ActionEvent event) throws RemoteException {
        String username = tfUsername.getText();
        String password = pfPassword.getText();
        validator = new EmptyInputValidator();
        boolean emptyInputFields = validator.isEmpty(username, password);

        if (emptyInputFields) {
            showInvalidLoginInputAlert();
        } else if (cbUserroles.getSelectionModel().getSelectedItem().contains(EMPLOYEE_ROLE)) {
            authentication = new EmployeeAuthenticationFactory().createAuthentication();
            if (authentication.authenticate(username, password)) {
                Platform.exit();
            }
        } else if (cbUserroles.getSelectionModel().getSelectedItem().contains(CUSTOMER_ROLE)) {
        }
    }

    void showInvalidLoginInputAlert() {
        Alert alert = new CyberiaAlert(Alert.AlertType.WARNING);
        alert.setTitle("Empty Fields");
        alert.setHeaderText("Please fill in all the fields");
        alert.setContentText("Both username and password fields are required");
        alert.showAndWait();
    }

    void showFailedLoginAlert() {
        Alert alert = new CyberiaAlert(Alert.AlertType.ERROR);
        alert.setTitle("Authentication failed");
        alert.setHeaderText("Account not found");
        alert.showAndWait();
    }
}