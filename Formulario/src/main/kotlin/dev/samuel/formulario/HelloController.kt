package dev.samuel.formulario

import javafx.fxml.FXML
import javafx.scene.control.*

class HelloController {
    @FXML
    lateinit var textField: TextField
    @FXML
    lateinit var addButton: Button
    @FXML
    lateinit var deleteButton: Button
    @FXML
    lateinit var aboutButton: MenuItem
    @FXML
    lateinit var exportButton: MenuItem
    @FXML
    lateinit var importButton: MenuItem
    @FXML
    lateinit var itemList: ListView<Any>
    @FXML
    lateinit var count: Label

}