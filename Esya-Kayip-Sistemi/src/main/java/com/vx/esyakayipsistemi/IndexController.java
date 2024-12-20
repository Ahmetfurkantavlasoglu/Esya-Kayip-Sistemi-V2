package com.vx.esyakayipsistemi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;

public class IndexController {

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private void handleLoginButtonAction() {
        try {
            // login.fxml dosyasını yükle
            Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/login.fxml"));
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Giriş Ekranı");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegisterButtonAction() {
        try {
            // register.fxml dosyasını yükle
            Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/register.fxml"));
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Kayıt Ekranı");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
