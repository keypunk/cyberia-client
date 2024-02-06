package com.cyberiashop.views.dialogs;

import com.cyberiashop.models.data_models.Product;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AddProductDialog extends Dialog<Product> {

    private final TableView<Product> tableView;
    private final ObservableList<Product> data;

    private TextField nameField;
    private TextField priceField;
    private Button addButton;
    private Button cancelButton;

    public AddProductDialog(TableView<Product> tableView, ObservableList<Product> data) {
        this.tableView = tableView;
        this.data = data;

        // Create dialog elements
        nameField = new TextField();
        priceField = new TextField();
        addButton = new Button("Add");
        cancelButton = new Button("Cancel");


        // Configure dialog layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10)); // Overall padding

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0); // Margin for name field

        grid.add(new Label("Price:"), 0, 1);
        grid.add(priceField, 1, 1); // Margin for price field

        HBox buttonBox = new HBox(10); // Horizontal spacing for buttons
        buttonBox.getChildren().addAll(addButton, cancelButton);
        grid.add(buttonBox, 1, 2); // Margin for button box
        // Set dialog content
        this.getDialogPane().setContent(grid);

        // Set dialog buttons
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        // Handle button actions
        addButton.setOnAction(event -> handleAdd());
        cancelButton.setOnAction(event -> this.setResult(null)); // Close dialog without adding product
    }

    private void handleAdd() {
        String name = nameField.getText();
        double price;
        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException e) {
            // Show error message if price is invalid
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Price");
            alert.setContentText("Please enter a valid numerical price.");
            alert.showAndWait();
            return;
        }

        // Create new product and add to data
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        data.add(newProduct);

        // Update TableView
        tableView.refresh();

        // Close dialog
        this.setResult(newProduct);
    }
}