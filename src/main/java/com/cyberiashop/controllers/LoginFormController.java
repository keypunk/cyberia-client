package com.cyberiashop.controllers;

import com.cyberiashop.models.utils.EmptyInputValidator;
import com.cyberiashop.models.business_logic.authentication.Authentication;
import com.cyberiashop.models.business_logic.authentication.EmployeeAuthenticationFactory;
import com.cyberiashop.models.utils.LoginAlerts;
import com.cyberiashop.views.scene_manager.ShopSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    // view elements on the login form that are modifiable for update purposes
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfUsername;
    @FXML
    private ComboBox<String> cbUserroles;

    // declaring and initializing user roles for comboBox
    private final String EMPLOYEE_ROLE = "Employee";
    private final String CUSTOMER_ROLE = "Customer";
    private final String[] USER_ROLES = { EMPLOYEE_ROLE, CUSTOMER_ROLE };

    // declaring authentication and sceneFactory which will be initialized by the login action
    private Authentication authentication;
    private SceneFactory sceneFactory;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        cbUserroles.getItems().addAll(USER_ROLES);
        // select first option in combobox as default otherwise the combobox would select an "empty" string
        cbUserroles.getSelectionModel().select(0);
    }

    @FXML
    void handleLoginAction(ActionEvent event) throws Exception {
        String username = tfUsername.getText();
        String password = pfPassword.getText();
        boolean emptyInputFields = EmptyInputValidator.isEmpty(username, password);

        if (emptyInputFields) {
            LoginAlerts.showInvalidLoginInputAlert();
        } else if (cbUserroles.getSelectionModel().getSelectedItem().contains(EMPLOYEE_ROLE)) {
            authentication = new EmployeeAuthenticationFactory().createAuthentication();
            if (authentication.authenticate(username, password)) {
                Platform.exit();
            } else {
                tfUsername.setText("");
                pfPassword.setText("");
                LoginAlerts.showFailedLoginAlert();
            }
        } else if (cbUserroles.getSelectionModel().getSelectedItem().contains(CUSTOMER_ROLE)) {
            sceneFactory = new ShopSceneFactory();
            sceneFactory.renderScene();
        }
    }
}