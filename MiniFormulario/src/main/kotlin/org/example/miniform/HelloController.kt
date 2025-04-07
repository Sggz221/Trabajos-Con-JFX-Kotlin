package org.example.miniform

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField


class HelloController {
    @FXML
    /**
     * Botón de enviar
     */
    lateinit var sendButton: Button

    @FXML
    /**
     * Texto invisible al principio que debe cambiar cuando se pulsa el botón
     */
    lateinit var formReceiver: Label

    @FXML
    /**
     * Caja de texto en la que puedes escribir
     */
    private lateinit var textBox: TextField

    @FXML
    /**
     * Funcion que se inicia cuando la aplicación se lanza
     */
    private fun initialize() {
        println("Aplicación inicializada")
        initEvents()
    }
    @FXML
    /**
     * Inicializa los eventos en el programa
     */
    private fun initEvents() {
        sendButton.setOnAction {
            sendForm()
        }
    }
    @FXML
    /**
     * Cambia el contenido de [formReceiver] con el texto de [textBox]
     */
    private fun sendForm() {
        formReceiver.text = textBox.text
        textBox.text = ""
    }
}