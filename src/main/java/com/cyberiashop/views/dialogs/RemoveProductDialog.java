package com.cyberiashop.views.dialogs;

import com.cyberiashop.models.business_logic.management_logic.ElectronicProductManagerFactory;
import com.cyberiashop.models.business_logic.management_logic.ProductManager;
import com.cyberiashop.models.data_models.Product;
import com.cyberiashop.models.exceptions.ProductManagerException;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Window;

import java.rmi.RemoteException;


public class RemoveProductDialog extends Dialog<String> {

    private ProductManager productManager;

    public RemoveProductDialog(Window owner, ObservableList<Product> observableList) {
        setTitle("Remove Product");
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

        // Add buttons
        ButtonType okButtonType = new ButtonType("Remove", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().add(okButtonType);
        Button okButton = (Button) getDialogPane().lookupButton(okButtonType);
        okButton.setOnAction(event -> {
            String name = nameField.getText();
            observableList.removeIf(p -> p.getName().equals(name));
            Thread removeProductFromDB = new Thread(() -> {
                productManager = new ElectronicProductManagerFactory().createProductManager();
                try {
                    productManager.removeProduct(name);
                } catch (RemoteException e) {
                    throw new ProductManagerException("Product manager service failed", e);
                }
            });

            removeProductFromDB.start();

        });

        ButtonType cancelButtonType = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        getDialogPane().getButtonTypes().add(cancelButtonType);

        // Set dialog content
        getDialogPane().setContent(grid);
    }
}