package com.cyberiashop.controllers;

import com.cyberiashop.models.business_logic.authentication.CustomerAuthenticationFactory;
import com.cyberiashop.models.business_logic.registration.CustomerRegistrationFactory;
import com.cyberiashop.models.business_logic.registration.Registration;
import com.cyberiashop.models.utils.EmptyInputValidator;
import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import com.cyberiashop.views.utils.RegisterAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.cyberiashop.models.business_logic.authentication.Authentication;

public class RegisterFormController {
    @FXML
    private PasswordField pfPassword;
    @FXML
    private PasswordField pfRepeatPassword;
    @FXML
    private TextField tfUsername;

    private Authentication authentication = new CustomerAuthenticationFactory().createAuthentication();
    private Registration registration = new CustomerRegistrationFactory().createRegistration();
    private SceneFactory sceneFactory;

    @FXML
    void handleRegisterAction(ActionEvent event) throws Exception {
        String username = tfUsername.getText();
        String password = pfPassword.getText();
        String repeatedPassword = pfRepeatPassword.getText();

        boolean emptyInputFields = EmptyInputValidator.isEmpty(username, password, repeatedPassword);

        if (emptyInputFields) {
            RegisterAlert.showInvalidRegisterInputAlert();
        } else if (!password.contains(repeatedPassword)) {
            RegisterAlert.showUnequalPasswordInputAlert();
        } else if (authentication.authenticate(username, password)) {
            RegisterAlert.showAccountAlreadyExistsAlert();
        } else {
            registration = new CustomerRegistrationFactory().createRegistration();
            registration.register(username, password);
            sceneFactory = new LoginSceneFactory();
            sceneFactory.renderScene();
        }
    }

    @FXML
    void handleGoBackToLogin(ActionEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }
}
