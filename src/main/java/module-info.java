module com.example.colores {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.colores to javafx.fxml;
    exports com.example.colores;
}