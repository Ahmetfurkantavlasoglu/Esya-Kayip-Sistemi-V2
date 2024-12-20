package com.vx.esyakayipsistemi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.io.IOException;

public class Login {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button backButton;

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        // Kullanıcı doğrulama
        if (email.equals("admin@gmail.com") && password.equals("1234")) {
            try {
                // admin.fxml dosyasını yükle
                Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/admin.fxml"));

                // Yeni bir sahne oluştur ve sahneyi ayarla
                Stage stage = (Stage) emailField.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Admin Ekranı");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (!email.isEmpty() && !password.isEmpty()) {
            try {
                // user.fxml dosyasını yükle
                Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/user.fxml"));

                // Yeni bir sahne oluştur ve sahneyi ayarla
                Stage stage = (Stage) emailField.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Kullanıcı Ekranı");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Giriş Başarısız");
            alert.setHeaderText(null);
            alert.setContentText("Geçersiz e-posta veya şifre.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBack() {
        try {
            // index.fxml dosyasını yükle
            Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/index.fxml"));

            // Yeni bir sahne oluştur ve sahneyi ayarla
            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ana Ekran");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
