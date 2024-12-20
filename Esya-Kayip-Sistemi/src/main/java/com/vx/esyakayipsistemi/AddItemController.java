package com.vx.esyakayipsistemi;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.io.IOException;

public class AddItemController {

    @FXML
    private TextField itemNameField;

    @FXML
    private TextField itemCategoryField;

    @FXML
    private TextField itemDateField;

    @FXML
    private ImageView itemImageView;

    private String itemImagePath;

    @FXML
    private void handleSaveItem() {
        String itemName = itemNameField.getText();
        String itemCategory = itemCategoryField.getText();
        String itemDate = itemDateField.getText();

        if (!itemName.isEmpty() && !itemCategory.isEmpty() && !itemDate.isEmpty()) {
            Item newItem = new Item(itemName, itemCategory, itemDate, itemImagePath);
            AdminController.addItem(newItem);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ekleme Başarılı");
            alert.setHeaderText(null);
            alert.setContentText("Yeni eşya başarıyla eklendi.");
            alert.showAndWait();

            // Ekleme işlemi sonrası AddItem penceresini kapat
            Stage stage = (Stage) itemNameField.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ekleme Başarısız");
            alert.setHeaderText(null);
            alert.setContentText("Lütfen tüm alanları doldurun.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getGestureSource() != itemImageView && event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        event.consume();
    }

    @FXML
    private void handleDragDropped(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            try {
                itemImagePath = db.getFiles().get(0).toURI().toString();
                Image image = new Image(itemImagePath);
                itemImageView.setImage(image);
                success = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        event.setDropCompleted(success);
        event.consume();
    }
}
