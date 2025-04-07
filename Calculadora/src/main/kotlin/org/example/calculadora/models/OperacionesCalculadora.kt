package dev.samuel.calculadora.models

interface OperacionesCalculadora {
    // Operaciones
    fun suma(a:Double, b:Double):Double
    fun resta(a: Double, b:Double):Double
    fun multiplicacion(a:Double, b:Double):Double
    fun división(a:Double, b:Double):Double
    fun porcentaje(a:Double):Double
    fun cuadrado(a:Double):Double
    fun raizCuadrada(a:Double):Double
    fun unoSobreX(a:Double):Double
}