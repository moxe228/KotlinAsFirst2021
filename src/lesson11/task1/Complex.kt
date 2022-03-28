@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import kotlin.math.pow

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex {
    try {
        var number = mutableListOf<String>()
        Regex("[-+]?\\d+[.]?\\d*").findAll(s).forEach { number.add(it.value) }
        return Complex(number[0].toDouble(), number[1].toDouble())
    } catch (e: Exception) {
        throw Exception("Не комплексное число")
    }
}

/**
 * Класс "комплексное число".
 *
 * Общая сложность задания -- лёгкая, общая ценность в баллах -- 8.
 * Объект класса -- комплексное число вида x+yi.
 * Про принципы работы с комплексными числами см. статью Википедии "Комплексное число".
 *
 * Аргументы конструктора -- вещественная и мнимая часть числа.
 */
class Complex(val re: Double, val im: Double) {
    /**
     * Конструктор из вещественного числа
     */
    constructor(x: Double) : this(x, 0.0)

    /**
     * Сложение.
     */
    operator fun plus(other: Complex): Complex = Complex(this.re + other.re, this.im + other.im)

    /**
     * Смена знака (у обеих частей числа)
     */
    operator fun unaryMinus(): Complex = Complex(re * -1, im * -1)

    /**
     * Вычитание
     */
    operator fun minus(other: Complex): Complex = Complex(this.re - other.re, this.im - other.im)

    /**
     * Умножение
     */
    operator fun times(other: Complex): Complex {
        val real = this.re * other.re - this.im * other.im
        val imaginary = this.re * other.im + other.re * this.im
        return Complex(real, imaginary)
    }

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val real = (other.re * this.re + other.im * this.im) / (other.re.pow(2) + other.im.pow(2))
        val imaginary = (other.re * this.im - this.re * other.im) / (other.re.pow(2) + other.im.pow(2))
        return Complex(real, imaginary)
    }

    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean {
        when {
            this === other -> return true
            other is Complex -> return re == other.re && im == other.im
            else -> return false
        }
    }

    override fun hashCode(): Int {
        var result = re
        result = 31 * result + im
        return result.toInt()
    }

    /**
     * Преобразование в строку
     */
    override fun toString(): String =
        if (im >= 0)
            "$re+${im}i"
        else
            "$re${im}i"
}
