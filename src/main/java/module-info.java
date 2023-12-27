module com.cyberiashop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires java.rmi;

    exports com.cyberiashop.controllers;
    opens com.cyberiashop.controllers to javafx.fxml;
    exports com.cyberiashop.views;
    opens com.cyberiashop.views to javafx.fxml;
}