package com.ia.ia_base.controllers.teachers;

import com.ia.ia_base.controllers.BaseController;
import com.ia.ia_base.models.Tag;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteTagController extends BaseController {
    @FXML
    public Button deleteTagBTN;
    @FXML
    public Button cancelBTN;
    @FXML
    public ComboBox<Tag> chooseTagCombo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setupActions();
    }

    private void setupActions() {
        cancelBTN.setOnAction(e -> {
            closeWindow();
        });
        deleteTagBTN.setOnAction(e -> {

        });
    }
}
