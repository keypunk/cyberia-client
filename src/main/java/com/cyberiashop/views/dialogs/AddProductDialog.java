package com.cyberiashop.views.dialogs;

import com.cyberiashop.models.business_logic.management_logic.ElectronicProductManagerFactory;
import com.cyberiashop.models.business_logic.management_logic.ProductManager;
import com.cyberiashop.models.data_models.Category;
import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.exceptions.ProductManagerException;
import com.cyberiashop.views.utils.DefaultProductImage;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

import java.rmi.RemoteException;

public class AddProductDialog extends Dialog<Product> {
    private ProductManager productManager;

    public AddProductDialog(Window owner, ObservableList<Product> observableList) {
        setTitle("Add Product");
        initOwner(owner);

        // Define dialog content
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        Label nameLabel = new Label("Product Name:");
        TextField nameField = new TextField();
        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);

        Label priceLabel = new Label("Price:");
        TextField priceField = new TextField();
        grid.add(priceLabel, 0, 1);
        grid.add(priceField, 1, 1);

        Label quantityLabel = new Label("Quantity:");
        TextField quantityField = new TextField();
        grid.add(quantityLabel, 0, 2);
        grid.add(quantityField, 1, 2);

        // Add buttons
        ButtonType okButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().add(okButtonType);
        Button okButton = (Button) getDialogPane().lookupButton(okButtonType);
        okButton.setOnAction(event -> {
            String name = nameField.getText();
            double price;
            int quantity;
            try {
                price = Double.parseDouble(priceField.getText());
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException e) {
                // Handle invalid input
                new Alert(Alert.AlertType.ERROR, "Invalid price or quantity.").showAndWait();
                return;
            }

            Product newProduct = new Product();
            newProduct.setName(name);
            newProduct.setPrice(price);
            newProduct.setQuantity(quantity);
            newProduct.setImgSrc(DefaultProductImage.getImagePath());
            newProduct.setCategory(Category.ACCESSORIES);
            observableList.add(newProduct);
            Thread addProductToDB = new Thread(() -> {
                productManager = new ElectronicProductManagerFactory().createProductManager();
                try {
                    productManager.addProduct(newProduct);
                } catch (RemoteException e) {
                    throw new ProductManagerException("Product manager service failed", e);
                }
            });

            addProductToDB.start();

        });

        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().add(cancelButtonType);

        // Set dialog content
        getDialogPane().setContent(grid);
    }
}