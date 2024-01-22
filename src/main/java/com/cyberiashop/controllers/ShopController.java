package com.cyberiashop.controllers;

import com.cyberiashop.models.business_logic.shop_logic.ElectronicProductSearchFactory;
import com.cyberiashop.models.business_logic.shop_logic.ProductSearch;
import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.exceptions.ProductSearchException;
import com.cyberiashop.views.scene_manager.LoginSceneFactory;
import com.cyberiashop.views.scene_manager.SceneFactory;
import com.cyberiashop.views.utils.EuroCurrency;
import com.cyberiashop.views.utils.ShopDimensions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
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
    private Spinner<Integer> itemQuantitySpinner;
    @FXML
    private GridPane grid;

    private ShopDimensions shopDimensions;

    private List<Product> products = new ArrayList<>();
    private Image image;
    private ProductSearch productSearch;

    private SceneFactory sceneFactory;


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

        try {
            addProductsToGridPane(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setChosenItemCard(Product product) {
        itemNameLabel.setText(product.getName());
        itemPriceLabel.setText(product.getPrice() + new EuroCurrency().getCurrency());
        image = new Image(getClass().getResourceAsStream(product.getImgSrc()));

        if (product.getQuantity() > 0) {
            SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory
                    .IntegerSpinnerValueFactory(1, product.getQuantity());

            itemQuantitySpinner.setValueFactory(valueFactory);
        }
    }

    public void addProductsToGridPane(List<Product> products) throws IOException {
        int column = 0;
        int row = 1;

        if (products.size() > 0) {
            setChosenItemCard(products.get(0));
        }

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
            shopDimensions = new ShopDimensions(grid);
            shopDimensions.applyDimensions();
            GridPane.setMargin(anchorPane, new Insets(10));
        }
    }

    @FXML
    void handleLogoutAction(ActionEvent event) throws Exception {
        sceneFactory = new LoginSceneFactory();
        sceneFactory.renderScene();
    }
}
