package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.data_models.ShoppingCart;
import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import com.cyberiashop.views.scene_manager.ShopSceneFactory;
import com.cyberiashop.views.utils.EuroCurrency;
import com.cyberiashop.views.utils.ShopDimensions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Insets;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class CartController implements Initializable {
    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    private SceneFactory sceneFactory;
    private ShoppingCart shoppingCart = ShoppingCart.getInstance();
    private ShopDimensions shopDimensions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Product> cartItems = shoppingCart.getProductCart();
        try {
            addProductsToGridPane(cartItems);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleBackToHomeAction(ActionEvent event) throws Exception {
        sceneFactory = new ShopSceneFactory();
        sceneFactory.renderScene();
    }

    @FXML
    void handleLogoutAction(ActionEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }

    @FXML
    void handlePurchaseAction(ActionEvent event) throws Exception {
        ShoppingCart.getInstance().clearCart();
        sceneFactory = new ShopSceneFactory();
        sceneFactory.renderScene();
    }

    public void addProductsToGridPane(List<Product> products) throws IOException {
        int column = 0;
        int row = 1;

        for (int i = 0; i < products.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/com/cyberiashop/cart-item-view.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            CartItemController cartItemController = fxmlLoader.getController();
            cartItemController.setProduct(products.get(i));
            cartItemController.setCurrency(new EuroCurrency());
            cartItemController.applyDataToView();

            if (column == 1) {
                column = 0;
                row++;
            }

            grid.add(anchorPane, column++, row); // add item cards to grid
            shopDimensions = new ShopDimensions(grid);
            shopDimensions.applyDimensions();
            GridPane.setMargin(anchorPane, new Insets(10));
        }
    }
}
