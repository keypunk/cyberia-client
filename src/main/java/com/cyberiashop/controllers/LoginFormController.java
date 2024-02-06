package com.cyberiashop.controllers;

import com.cyberiashop.models.business_logic.authentication.CustomerAuthenticationFactory;
import com.cyberiashop.models.business_logic.authentication.UserSession;
import com.cyberiashop.models.utils.EmptyInputValidator;
import com.cyberiashop.models.business_logic.authentication.Authentication;
import com.cyberiashop.models.business_logic.authentication.EmployeeAuthenticationFactory;
import com.cyberiashop.views.utils.LoginAlerts;
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
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

    // 'view elements' on the login form that are modifiable for update purposes
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
        // add user roles to the comboBox
        cbUserroles.getItems().addAll(USER_ROLES);
        // select first option in combobox as default otherwise the combobox would select an "empty" string
        cbUserroles.getSelectionModel().select(0);
    }

    @FXML
    void handleLoginAction(ActionEvent event) throws Exception {
        String username = tfUsername.getText();
        String password = pfPassword.getText();
        String selectedUserRole = cbUserroles.getSelectionModel().getSelectedItem();
        boolean emptyInputFields = EmptyInputValidator.isEmpty(username, password);

        if (emptyInputFields) {
            LoginAlerts.showInvalidLoginInputAlert();
        } else if (selectedUserRole.contains(EMPLOYEE_ROLE)) {
            handleEmployeeLoginAction(username, password);
        } else if (selectedUserRole.contains(CUSTOMER_ROLE)) {
            handleCustomerLoginAction(username, password);
        }
    }

    void handleCustomerLoginAction(String username, String password) throws Exception {
        authentication = new CustomerAuthenticationFactory().createAuthentication();

        if (authentication.authenticate(username, password)) {
            UserSession.getInstance().setUsername(username);
            sceneFactory = new ShopSceneFactory();
            sceneFactory.renderScene();
        } else {
            tfUsername.setText("");
            pfPassword.setText("");
            LoginAlerts.showFailedLoginAlert();
        }
    }

    void handleEmployeeLoginAction(String username, String password) throws Exception {
        authentication = new EmployeeAuthenticationFactory().createAuthentication();

        if (authentication.authenticate(username, password)) {
            UserSession.getInstance().setUsername(username);
            // SceneFactory for Employee manager
            Platform.exit();
        } else {
            tfUsername.setText("");
            pfPassword.setText("");
            LoginAlerts.showFailedLoginAlert();
        }
    }
}