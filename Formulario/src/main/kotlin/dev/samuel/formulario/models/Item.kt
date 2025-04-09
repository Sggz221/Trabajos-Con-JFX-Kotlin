package dev.samuel.formulario.models

data class Item(
    val nombre: String,
    val edad: Int,
    val nota: Double
) {
    override fun toString() : String {
        return "$nombre, $edad, $nota"
    }
}