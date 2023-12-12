module com.cyberiashop.cyberiaclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    exports com.cyberiashop.cyberiaclient.controllers;
    opens com.cyberiashop.cyberiaclient.controllers to javafx.fxml;
    exports com.cyberiashop.cyberiaclient.views;
    opens com.cyberiashop.cyberiaclient.views to javafx.fxml;
}