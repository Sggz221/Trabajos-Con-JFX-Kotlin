module dev.samuel.miniformulario {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens dev.samuel.miniformulario to javafx.fxml;
    exports dev.samuel.miniformulario;
}