module dev.samuel.formulario {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens dev.samuel.formulario to javafx.fxml;
    exports dev.samuel.formulario;
}