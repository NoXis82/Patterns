package structure.adapter.square

import kotlin.math.pow

/**
 * Квадратные колышки несовместимы с круглыми отверстиями (они остались в проекте
 * после бывших разработчиков). Но мы должны как-то интегрировать их в нашу
 * систему.
 */
class SquarePeg() {

    private var width: Double = 0.0

    constructor(width: Double) : this() {
        this.width = width
    }

    fun getWidth(): Double {
        return width
    }

    fun getSquare(): Double {
        return this.width.pow(2)
    }
}