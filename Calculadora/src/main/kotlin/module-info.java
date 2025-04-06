module dev.samuel.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens dev.samuel.calculadora to javafx.fxml;
    exports dev.samuel.calculadora;
}