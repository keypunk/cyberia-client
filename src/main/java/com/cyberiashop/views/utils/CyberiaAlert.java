package com.cyberiashop.views.utils;

import com.cyberiashop.Client;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class CyberiaAlert extends Alert {
    public CyberiaAlert(AlertType alertType) {
        super(alertType);
        initOwner(Client.getStage());
        initStyle(StageStyle.UNDECORATED);
    }
}
