package com.cyberiashop.controllers;

import com.cyberiashop.Client;
import com.cyberiashop.models.business_logic.shop_logic.ElectronicProductSearchFactory;
import com.cyberiashop.models.business_logic.shop_logic.ProductSearch;
import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.exceptions.ProductSearchException;
import com.cyberiashop.views.dialogs.AddProductDialog;
import com.cyberiashop.views.dialogs.RemoveProductDialog;
import com.cyberiashop.views.scene_manager.EmployeeManagementSceneFactory;
import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

public class ProductManagementController implements Initializable {

    @FXML
    private TableView<Product> productTableView;
    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, Double> priceCol;
    @FXML
    private TableColumn<Product, Integer> quantityCol;

    private SceneFactory sceneFactory;
    private ProductSearch productSearch;
    private ObservableList<Product> observableProducts;
    private List<Product> products = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Thread requestProductDB = new Thread(() -> {
            productSearch = new ElectronicProductSearchFactory().createProductSearch();
            try {
                products.addAll(productSearch.emptySearch());
            } catch (RemoteException e) {
                throw new ProductSearchException("Product search service failed", e);
            }
        });

        requestProductDB.start();

        try {
            requestProductDB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        nameCol.setText("Product name");
        priceCol.setText("Product price");
        quantityCol.setText("Quantity");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        observableProducts = FXCollections.observableList(products);
        productTableView.setItems(observableProducts);

    }

    @FXML
    void handleOpenAddProductAction(ActionEvent event) {
        new AddProductDialog(Client.getStage(), observableProducts).showAndWait();
    }

    @FXML
    void handleOpenRemoveProductAction(ActionEvent event) {
        new RemoveProductDialog(Client.getStage(), observableProducts).showAndWait();
    }

    @FXML
    void handleEmployeeManagementAction(ActionEvent event) throws Exception {
        sceneFactory = new EmployeeManagementSceneFactory();
        sceneFactory.renderScene();
    }

    @FXML
    void handleLogoutAction(ActionEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }
}
