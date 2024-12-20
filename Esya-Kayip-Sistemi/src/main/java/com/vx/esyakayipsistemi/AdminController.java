package com.vx.esyakayipsistemi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminController {

    @FXML
    private HBox itemContainer;

    private static List<Item> itemList = new ArrayList<>();

    public static void addItem(Item item) {
        itemList.add(item);
        // Kullanıcı ekranında eşyaları güncelle
        UserController.updateItemContainer(); // UserController'ı çağırarak güncellemeleri yap
    }

    public static List<Item> getItemList() {
        return itemList;
    }

    @FXML
    private void initialize() {
        updateItemContainer();
    }

    @FXML
    public void updateItemContainer() {
        itemContainer.getChildren().clear();
        for (Item item : itemList) {
            VBox itemBox = new VBox(5);
            ImageView imageView = new ImageView(new Image(item.getImagePath()));
            imageView.setFitHeight(150); // Fotoğraf boyutunu artırdım
            imageView.setFitWidth(150);  // Fotoğraf boyutunu artırdım
            VBox.setMargin(imageView, new Insets(0, 0, 10, 0)); // Fotoğrafın altına boşluk ekledim

            Label nameLabel = new Label("İsim: " + item.getName());
            nameLabel.setFont(new Font("Arial", 16)); // Yazı boyutunu artırdım
            Label categoryLabel = new Label("Kategori: " + item.getCategory());
            categoryLabel.setFont(new Font("Arial", 16)); // Yazı boyutunu artırdım
            Label dateLabel = new Label("Tarih: " + item.getDate());
            dateLabel.setFont(new Font("Arial", 16)); // Yazı boyutunu artırdım

            itemBox.getChildren().addAll(imageView, nameLabel, categoryLabel, dateLabel);
            itemContainer.getChildren().add(itemBox);
        }
    }

    @FXML
    private void handleNewItem() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/vx/esyakayipsistemi/addItem.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Yeni Eşya Ekle");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            // Yeni eklenen eşyaları güncelle
            updateItemContainer();
            UserController.updateItemContainer(); // UserController'ı çağırarak güncellemeleri yap
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/vx/esyakayipsistemi/index.fxml"));
            Stage stage = (Stage) itemContainer.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Ana Ekran");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
