module org.example.calcooladora {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens org.example.calcooladora to javafx.fxml;
    exports org.example.calcooladora;
}