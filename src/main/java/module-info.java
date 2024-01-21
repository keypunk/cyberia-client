module com.cyberiashop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.rmi;
    requires java.desktop;
    requires jakarta.persistence;

    exports com.cyberiashop.controllers;
    opens com.cyberiashop.controllers to javafx.fxml;
    opens com.cyberiashop to javafx.fxml;
    exports com.cyberiashop.views.utils;
    opens com.cyberiashop.views.utils to javafx.fxml;
    exports com.cyberiashop;
    exports com.cyberiashop.views.scene_manager;
    opens com.cyberiashop.views.scene_manager to javafx.fxml;
    exports com.cyberiashop.models.data_models;
}