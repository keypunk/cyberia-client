package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Employee;
import com.cyberiashop.models.data_models.User;
import com.cyberiashop.models.exceptions.UserSearchException;
import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.ProductManagementSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeManagementController implements Initializable {
    @FXML
    private TableView<User> employeeTableView;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, String> passwordCol;

    private SceneFactory sceneFactory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameCol.setText("Employee name");
        passwordCol.setText("Employee password");
    }

    @FXML
    void handleOpenAddEmployeeAction(ActionEvent event) {
    }

    @FXML
    void handleOpenRemoveEmployeeAction(ActionEvent event) {
    }

    @FXML
    void handleProductManagementAction(ActionEvent event) throws Exception {
        sceneFactory = new ProductManagementSceneFactory();
        sceneFactory.renderScene();
    }

    @FXML
    void handleLogoutAction(ActionEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }
}
