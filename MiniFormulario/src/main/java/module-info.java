module org.example.miniform {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens org.example.miniform to javafx.fxml;
    exports org.example.miniform;
}