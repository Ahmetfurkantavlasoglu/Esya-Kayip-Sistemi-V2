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

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button backButton;

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // Basit doğrulama (Gelecekte burada gerçek bir doğrulama mekanizması ekleyebilirsiniz)
        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Kayıt Başarılı");
            alert.setHeaderText(null);
            alert.setContentText("Kayıt başarılı! Hoş geldiniz " + username + "!");
            alert.showAndWait();

            // Kayıt başarılı olduğunda login sayfasına yönlendirme
            try {
                // login.fxml dosyasını yükle
                Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/login.fxml"));

                // Yeni bir sahne oluştur ve sahneyi ayarla
                Stage stage = (Stage) emailField.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Giriş Ekranı");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Kayıt Başarısız");
            alert.setHeaderText(null);
            alert.setContentText("Lütfen tüm alanları doldurun.");
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
