package com.ia.ia_base.controllers;

import com.ia.ia_base.config.AppConfig;
import com.ia.ia_base.database.DatabaseConnection;
import com.ia.ia_base.util.AlertManager;
import com.ia.ia_base.util.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WelcomeController extends BaseController {

    private static final String FLASHCARD_TABLE = "flashcards";
    private static final String QUIZ_TABLE = "quizzes";

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

        int flashCount = fetchCount(FLASHCARD_TABLE);
        int quizCount = fetchCount(QUIZ_TABLE);

        String flash = "There are currently " + flashCount + " flashcards";
        String quiz = "There are currently " + quizCount + " quizzes";
        flashcardAmountText.setText(flash);
        quizAmountText.setText(quiz);
    }

    private int fetchCount(String tableName) {
        if (!AppConfig.isUseDatabase()) {
            return 0;
        }

        String sql = "SELECT COUNT(*) AS total FROM " + tableName;
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            AlertManager.showError("Database Error", "Failed to load " + tableName + " count: " + e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }
}