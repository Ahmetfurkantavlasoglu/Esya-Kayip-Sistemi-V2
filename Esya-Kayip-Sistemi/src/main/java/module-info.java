module com.vx.esyakayipsistemi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vx.esyakayipsistemi to javafx.fxml;
    exports com.vx.esyakayipsistemi;
}