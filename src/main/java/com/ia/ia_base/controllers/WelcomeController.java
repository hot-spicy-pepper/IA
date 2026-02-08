package com.ia.ia_base.controllers;

import com.ia.ia_base.util.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController extends BaseController {

    @FXML
    public Text greetingText;
    @FXML
    public Text flashcardAmountText;
    @FXML
    public Text quizAmountText;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        setupInformation();
    }

    private void setupInformation() {
        String greet = "Welcome, " + SessionManager.getInstance().getCurrentUser().getEmail();
        greetingText.setText(greet);

        String flash = "There are currently " +
    }
}
