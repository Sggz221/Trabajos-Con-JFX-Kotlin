package dev.samuel.calculadora

import dev.samuel.calculadora.models.Calculadora
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color

class HelloController(val calculadora: Calculadora) {
    // Components

    @FXML
    /**
     * Botón de igual
     */
    lateinit var equals: Button

    @FXML
    /**
     * Botón de suma
     */
    lateinit var addition: Button

    @FXML
    /**
     * Botón de resta
     */
    lateinit var substraction: Button

    @FXML
    /**
     * Botón de coma para números decimales
     */
    lateinit var floatingPoint: Button

    @FXML
    /**
     * Botón 3
     */
    lateinit var threeButton: Button

    @FXML
    /**
     * Botón 6
     */
    lateinit var sixButton: Button

    @FXML
    /**
     * Botón 0
     */
    lateinit var zeroButton: Button

    @FXML
    /**
     * Botón 2
     */
    lateinit var twoButton: Button

    @FXML
    /**
     * Botón 5
     */
    lateinit var fiveButton: Button

    @FXML
    /**
     * Botón de inversión de signo
     */
    lateinit var invertSign: Button

    @FXML
    /**
     * Botón 1
     */
    lateinit var oneButton: Button

    @FXML
    /**
     * Botón 4
     */
    lateinit var fourButton: Button

    @FXML
    /**
     * Botón de multiplicación
     */
    lateinit var multiplication: Button

    @FXML
    /**
     * Botón 9
     */
    lateinit var nineButton: Button

    @FXML
    /**
     * Botón 8
     */
    lateinit var eightButton: Button

    @FXML
    /**
     * Botón 7
     */
    lateinit var sevenButton: Button

    @FXML
    /**
     * Botón de división
     */
    lateinit var division: Button

    @FXML
    /**
     * Botón de raíz cuadrada
     */
    lateinit var squareRoot: Button

    @FXML
    /**
     * Botón elevar al cuadrado
     */
    lateinit var squared: Button

    @FXML
    /**
     * Botón de elevar a -1
     */
    lateinit var oneOverX: Button

    @FXML
    /**
     * Botón de borrar un dígito
     */
    lateinit var back: Button

    @FXML
    /**
     * Botón para borrar todo, incluida la pila de operaciones
     */
    lateinit var clearAll: Button

    @FXML
    /**
     * Botón de borrar sólo la línea principal
     */
    lateinit var clearE: Button

    @FXML
    /**
     * Botón de porcentaje
     */
    lateinit var percentage: Button

    @FXML
    /**
     * Área de texto que muestra los números introducidos por el usuario y los resultados
     */
    lateinit var numberQueue: Label


    @FXML
    /**
     * Pila de operaciones que sirve a modo de historial
     */
    lateinit var operationStack: Label

    /**
     * Ultimo resultado disponible
     */
    private var previousAnswer: Double = 0.0

    /**
     * Elemento 1 almacenado en la pila de operaciones
     */
    private var element1: Double = 0.0

    /**
     * Elemento 2 almacenado en la pila de operaciones
     */
    private var element2: Double = 0.0
    // Methods

    fun buttonZeroPressed() {
        numberQueue.text += "0"
    }

    fun buttonOnePressed() {
        numberQueue.text += "1"
    }

    fun buttonTwoPressed() {
        numberQueue.text += "2"
    }

    fun buttonThreePressed() {
        numberQueue.text += "3"
    }

    fun buttonFourPressed() {
        numberQueue.text += "4"
    }

    fun buttonFivePressed() {
        numberQueue.text += "5"
    }

    fun buttonSixPressed() {
        numberQueue.text += "6"
    }

    fun buttonSevenPressed() {
        numberQueue.text += "7"
    }

    fun buttonEightPressed() {
        numberQueue.text += "8"
    }

    fun buttonNinePressed() {
        numberQueue.text += "9"
    }

    fun buttonPercentagePressed() {
        val result = calculadora.porcentaje(numberQueue.text.toDouble())
        numberQueue.text = "$result"
    }

    fun buttonClearEPressed() {
        numberQueue.text = ""
    }

    fun buttonClearAllPressed() {
        numberQueue.text = ""
        operationStack.text = "= "
    }

    fun buttonDeletePressed() {
        numberQueue.text = numberQueue.text.slice(IntRange(0, numberQueue.text.length - 2))
    }

    fun button1OverXPressed() {
        val result = calculadora.unoSobreX(numberQueue.text.toDouble())
        numberQueue.text = "$result"
    }

    fun buttonSquaredPressed() {
        val result = calculadora.cuadrado(numberQueue.text.toDouble())
        numberQueue.text = "$result"
    }

    fun buttonSqrtPressed() {
        val result = calculadora.raizCuadrada(numberQueue.text.toDouble())
        numberQueue.text = "$result"
    }

    fun buttonDividePressed() {
        operationStack.text = "$element1 / = "
    }

    fun buttonMultiplyPressed() {
        operationStack.text = "$element1 x = "
    }

    fun buttonMinusPressed() {
        operationStack.text = "$element1 - = "
    }

    fun buttonPlusPressed() {
        operationStack.text = "$element1 + = "
    }

    fun buttonInversionPressed() {
        val result = numberQueue.text.toDouble() * -1.0
    }

    fun buttonCommaPressed() {
        /*
        COSAS A COMPROBAR:
        - Cualquier cosa que se divida por 0 salta una excepción. Revisar 1 sobre X
        - Los botones de operaciones se deben poder pulsar solo una vez por cada cálculo
        - A la hora de calcular porcentajes usar el número anterior como porcentaje. Por defecto 0
        - Incluir en las operaciones lo de lemento 1 y elemento 2
         */
    }

    fun buttonEqualsPressed() {

    }
}