package org.example.calculadora

import dev.samuel.calculadora.models.Calculadora
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import org.example.calcooladora.utils.round
import kotlin.math.roundToInt


class HelloController {
    // Components
    private val calculadora = Calculadora()

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

    /**
     * Establece si se ha pulsado el boton de coma
     */
    private var commaUsed: Boolean = false
    // Methods
    /**
     * Añade un 0
     */
    fun buttonZeroPressed() {
        numberQueue.text += "0"
    }

    /**
     * Añade un 1
     */
    fun buttonOnePressed() {
        numberQueue.text += "1"
    }

    /**
     * Añade un 2
     */
    fun buttonTwoPressed() {
        numberQueue.text += "2"
    }

    /**
     * Añade un 3
     */
    fun buttonThreePressed() {
        numberQueue.text += "3"
    }

    /**
     * Añade un 4
     */
    fun buttonFourPressed() {
        numberQueue.text += "4"
    }

    /**
     * Añade un 5
     */
    fun buttonFivePressed() {
        numberQueue.text += "5"
    }

    /**
     * Añade un 6
     */
    fun buttonSixPressed() {
        numberQueue.text += "6"
    }

    /**
     * Añade un 7
     */
    fun buttonSevenPressed() {
        numberQueue.text += "7"
    }

    /**
     * Añade un 8
     */
    fun buttonEightPressed() {
        numberQueue.text += "8"
    }

    /**
     * Añade un 9
     */
    fun buttonNinePressed() {
        numberQueue.text += "9"
    }

    /**
     * Calcula el porcentaje especificado en el prompt del numero anterior
     */
    fun buttonPercentagePressed() {
        val result = calculadora.porcentaje(processPrompt(numberQueue.text)) * element1
        numberQueue.text = "${result.round(5)}"
    }

    /**
     * Elimina el contenido de la linea de prompt
     */
    fun buttonClearEPressed() {
        clearQueue()
        commaUsed = false
    }

    /**
     * Elimina la pila de operaciones y el contenido de la linea de prompt
     */
    fun buttonClearAllPressed() {
        clearQueue()
        element1 = 0.0
        element2 = 0.0
        commaUsed = false
        operationStack.text = "= "
    }

    /**
     * Elimina el ultimo elemento de la linea de prompt
     */
    fun buttonDeletePressed() {
        numberQueue.text = numberQueue.text.slice(IntRange(0, numberQueue.text.length - 2))
    }

    /**
     * Realiza una funcion de inversion del elemento en la linea de prompt
     */
    fun button1OverXPressed() {
        val result = calculadora.unoSobreX(processPrompt(numberQueue.text))
        numberQueue.text = "${result.round(5)}"
    }

    /**
     * Eleva al cuadrado el elemento de la linea de prompt
     */
    fun buttonSquaredPressed() {
        val result = calculadora.cuadrado(processPrompt(numberQueue.text))
        numberQueue.text = "$result"
    }

    /**
     * Realiza la raiz cuadrada del elemento en la linea de prompt
     */
    fun buttonSqrtPressed() {
        val result = calculadora.raizCuadrada(processPrompt(numberQueue.text))
        numberQueue.text = "${result.round(5)}"
    }

    /**
     * Prepara el prompt para realizar una division
     */
    fun buttonDividePressed() {
        val prompt = processPrompt(numberQueue.text)
        if (element1 == 0.0) element1 = prompt
        else element2 = prompt
        numberQueue.text = ""
        operationStack.text = "$element1 / = "
    }

    /**
     * Prepara el prompt para realizar una multiplicacion
     */
    fun buttonMultiplyPressed() {
        val prompt = processPrompt(numberQueue.text)
        if (element1 == 0.0) element1 = prompt
        else element2 = prompt
        numberQueue.text = ""
        operationStack.text = "$element1 x = "
    }

    /**
     * Prepara el prompt para realizar una resta
     */
    fun buttonMinusPressed() {
        val prompt = processPrompt(numberQueue.text)
        if (element1 == 0.0) element1 = prompt
        else element2 = prompt
        numberQueue.text = ""
        operationStack.text = "$element1 - = "
    }

    /**
     * Prepara el prompt para realizar una suma
     */
    fun buttonPlusPressed() {
        val prompt = processPrompt(numberQueue.text)
        if (element1 == 0.0) element1 = prompt
        else element2 = prompt
        numberQueue.text = ""
        operationStack.text = "$element1 + = "
    }

    /**
     * Cambia el signo del prompt
     */
    fun buttonInversionPressed() {
        val result = processPrompt(numberQueue.text) * -1
        numberQueue.text = ""
        numberQueue.text = result.toString()
    }

    /**
     * Pone la coma de decimales
     */
    fun buttonCommaPressed() {
        if(!commaUsed) {
            numberQueue.text += "."
            commaUsed = true
        }
    }

    /**
     * Resuelve la operacion con la linea de prompt y la pila de operaciones
     */
    fun buttonEqualsPressed() {
        val operationSign = getOperation()
        commaUsed = false
        evaluateStack()
        when (operationSign) {
            "+" -> {
                val result = element1 + element2
                numberQueue.text = "$result"
                operationStack.text = "$element1 + $element2 = "
                element1 = result //Element1 almacena el resultado anterior
            }

            "-" -> {
                val result = element1 - element2
                numberQueue.text = "$result"
                operationStack.text = "$element1 - $element2 = "
                element1 = result
            }

            "x" -> {
                val result = element1 * element2
                numberQueue.text = "$result"
                operationStack.text = "$element1 x $element2 = "
                element1 = result
            }

            "/" -> {
                if (element2 == 0.0) numberQueue.text = "Error dividir por 0"
                else {
                    val result = element1 / element2
                    numberQueue.text = "$result"
                    operationStack.text = "$element1 / $element2 = "
                    element1 = result
                }
            }
        }
    }

    /**
     * Obtiene que operacion se quiere hacer
     */
    private fun getOperation(): String {
        val prompt: List<String?> = operationStack.text.split(" ")
        return prompt[1]!!
    }

    /**
     * Evalua la pila de prompts
     */
    private fun evaluateStack() {
        val prompt: List<String?> = operationStack.text.split(" ")
        element2 = prompt[2]?.toDoubleOrNull() ?: processPrompt(numberQueue.text) // Process prompt ya evita nulos
    }

    /**
     * Procesa [numberQueue] para que devuelva un doble
     */
    private fun processPrompt(numberQueue: String?): Double {
        val result = numberQueue?.toDoubleOrNull() ?: 0.0
        return result.round(5)
    }

    /**
     * Limpia la cola de numeros
     */
    private fun clearQueue() {
        numberQueue.text = ""
    }
}