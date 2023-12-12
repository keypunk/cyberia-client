package com.cyberiashop.cyberiaclient.controllers;

import com.cyberiashop.cyberiaclient.models.LoginAuthenticator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfUsername;

    @FXML
    private ComboBox<String> cbUserroles;

    private final String[] userroles = { "Employee", "Customer" };
    private LoginAuthenticator loginAuthenticator = new LoginAuthenticator();

    @FXML
    void handleLoginAction(ActionEvent event) {
        String username = tfUsername.getText();
        String password = pfPassword.getText();



    }

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        cbUserroles.getItems().addAll(userroles);
        cbUserroles.getSelectionModel().select(0);
    }

    public void handleMouseEntered(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource();
        node.setCursor(Cursor.HAND);
    }
}
