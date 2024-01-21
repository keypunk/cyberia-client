package com.cyberiashop.controllers;

import com.cyberiashop.models.data_models.Category;
import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import com.cyberiashop.views.utils.EuroCurrency;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShopController implements Initializable {

    @FXML
    private VBox chosenItemCard;
    @FXML
    private ImageView itemImg;
    @FXML
    private Label itemNameLabel;
    @FXML
    private Label itemPriceLabel;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<Product> products = new ArrayList<>();

    private SceneFactory sceneFactory;

    private List<Product> getData() {
        List<Product> products = new ArrayList<>();
        Product product;

        for (int i = 0; i < 20; i++) {
            product = new Product();
            product.setName("Dell Latitude 7400");
            product.setPrice(799.99);
            product.setCategory(Category.LAPTOP);
            product.setQuantity(5);
            product.setImgSrc("/com/cyberiashop/product_images/dell_latitude_7400.jpg");
            products.add(product);
        }

        return products;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        products.addAll(getData());
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < products.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/com/cyberiashop/item-view.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setProduct(products.get(i));
                itemController.setCurrency(new EuroCurrency());
                itemController.applyDataToView();

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); // add item cards to grid
                GridPane.setMargin(anchorPane, new Insets(20));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleLogoutAction(ActionEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }
}
