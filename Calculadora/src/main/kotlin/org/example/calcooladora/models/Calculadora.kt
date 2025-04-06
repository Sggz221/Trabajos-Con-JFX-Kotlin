package dev.samuel.calculadora.models

import kotlin.math.sqrt

class Calculadora(): OperacionesCalculadora {
    var pilaOperaciones = listOf("", "", "")
    var lineaOperaciones = listOf("", "", "")

    /**
     * Suma el elemento A con el elemento B
     */
    override fun suma(a: Double, b: Double): Double {
        return a + b
    }

    /**
     * Resta el elemento B al elemento A
     */
    override fun resta(a: Double, b: Double): Double {
        return a - b
    }

    /**
     * Multiplica el elemento A por el elemento B
     */
    override fun multiplicacion(a: Double, b: Double): Double {
        return a * b
    }

    /**
     * Divide el elemento A por el elemento B
     */
    override fun división(a: Double, b: Double): Double {
        return a / b
    }

    /**
     * Devuelve el elemento A en forma de porcentaje
     */
    override fun porcentaje(a: Double): Double {
        return a / 100.0
    }

    /**
     * Eleva el elemento A al cuadrado
     */
    override fun cuadrado(a: Double): Double {
        return a * a
    }

    /**
     * Hace la raiz cuadrada del elemento A
     */
    override fun raizCuadrada(a: Double): Double {
        return sqrt(a)
    }

    /**
     * Eleva el elemento A a -1
     */
    override fun unoSobreX(a: Double): Double {
        return 1.0 / a
    }
}