package com.ia.ia_base.controllers.teachers;

import com.ia.ia_base.controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateTagController extends BaseController {
    @FXML
    public TextField TagTextField;
    @FXML
    public Button createTagBTN;
    @FXML
    public Button cancelBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupActions();
    }

    private void setupActions() {
        cancelBTN.setOnAction(e -> {
            closeWindow();
        });
        
    }
}
