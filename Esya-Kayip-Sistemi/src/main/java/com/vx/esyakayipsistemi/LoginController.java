package com.vx.esyakayipsistemi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import java.io.IOException;
import java.util.List;

public class LoginController {

    @FXML
    private TextField emailField; // usernameField yerine emailField

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String email = emailField.getText(); // username yerine email
        String password = passwordField.getText();

        List<User> userList = UserController.getUserList();
        boolean isAuthenticated = userList.stream().anyMatch(user -> user.getEmail().equals(email) && user.getPassword().equals(password)); // username yerine email

        if (isAuthenticated) {
            if (email.equals("admin@gmail.com")) { // username yerine email
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/admin.fxml"));
                    Stage stage = (Stage) emailField.getScene().getWindow(); // usernameField yerine emailField
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Admin Paneli");
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/user.fxml"));
                    Stage stage = (Stage) emailField.getScene().getWindow(); // usernameField yerine emailField
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Kullanıcı Ekranı");
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Giriş Hatası");
            alert.setHeaderText(null);
            alert.setContentText("Email veya şifre hatalı."); // Kullanıcı adı yerine Email
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/index.fxml"));
            Stage stage = (Stage) emailField.getScene().getWindow(); // usernameField yerine emailField
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ana Ekran");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
