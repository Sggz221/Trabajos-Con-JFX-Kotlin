package org.example.calcooladora.utils



fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    for (i in 1..decimals) { multiplier *= 10 }
    return Math.round(this * multiplier) / multiplier
}