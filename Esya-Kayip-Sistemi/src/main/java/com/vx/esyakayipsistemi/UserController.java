package com.vx.esyakayipsistemi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private HBox itemContainer;

    private static List<User> userList = new ArrayList<>();

    static {
        // Admin kullanıcısını listeye ekleyelim
        userList.add(new User("admin", "admin@gmail.com", "1234"));
    }

    public static List<User> getUserList() {
        return userList;
    }

    @FXML
    private void handleRegister() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        userList.add(new User(username, email, password));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kayıt Başarılı");
        alert.setHeaderText(null);
        alert.setContentText("Kullanıcı başarıyla kaydedildi.");
        alert.showAndWait();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/login.fxml"));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Giriş Yap");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/index.fxml"));
            Stage stage = (Stage) usernameField.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ana Ekran");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        updateItemContainer();
    }

    public static void updateItemContainer() {
        UserController instance = new UserController();
        if (instance.itemContainer != null) {
            instance.itemContainer.getChildren().clear();
            for (Item item : AdminController.getItemList()) {
                VBox itemBox = new VBox(5);
                ImageView imageView = new ImageView(new Image(item.getImagePath()));
                imageView.setFitHeight(150);
                imageView.setFitWidth(150);
                VBox.setMargin(imageView, new Insets(0, 0, 10, 0));

                Label nameLabel = new Label("İsim: " + item.getName());
                nameLabel.setFont(new Font("Arial", 16));
                Label categoryLabel = new Label("Kategori: " + item.getCategory());
                categoryLabel.setFont(new Font("Arial", 16));
                Label dateLabel = new Label("Tarih: " + item.getDate());
                dateLabel.setFont(new Font("Arial", 16));

                itemBox.getChildren().addAll(imageView, nameLabel, categoryLabel, dateLabel);
                instance.itemContainer.getChildren().add(itemBox);
            }
        }
    }
}
