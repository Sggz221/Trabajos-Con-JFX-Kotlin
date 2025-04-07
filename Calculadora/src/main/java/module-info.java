module org.example.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens org.example.calculadora to javafx.fxml;
    exports org.example.calculadora;
}