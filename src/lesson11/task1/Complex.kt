@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

import ru.spbstu.wheels.toRecordString
import kotlin.math.pow

/**
 * Фабричный метод для создания комплексного числа из строки вида x+yi
 */
fun Complex(s: String): Complex {
    val list = s.replace("i", "").replace("-", " -").replace("+", " +").split(" ")
    if (list.first().isEmpty()) {
        return Complex(list[1].toDouble(), list[2].toDouble())
    } else {
        return Complex(list[0].toDouble(), list[1].toDouble())
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
        val a = this.re * other.re - this.im * other.im
        val b = this.re * other.im + other.re * this.im
        return Complex(a, b)
    }

    /**
     * Деление
     */
    operator fun div(other: Complex): Complex {
        val a = (other.re * this.re + other.im * this.im) / (other.re.pow(2) + other.im.pow(2))
        val b = (other.re * this.im - this.re * other.im) / (other.re.pow(2) + other.im.pow(2))
        return Complex(a, b)
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

    /**
     * Преобразование в строку
     */
    override fun toString(): String {
        if (im > 0){
            return "$re+${im}i"
            println("$re+${im}i")
        }else{
            return "$re${im}i"
            println("$re${im}i")
        }
    }
}
