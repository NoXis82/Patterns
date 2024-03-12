package structure.adapter.adapters

import structure.adapter.round.RoundPeg
import structure.adapter.square.SquarePeg
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Адаптер позволяет использовать квадратные колышки и круглые отверстия вместе.
 */
class SquarePegAdapter() : RoundPeg() {

    private var peg: SquarePeg? = null

    constructor(peg: SquarePeg) : this() {
        this.peg = peg
    }

    override fun getRadius(): Double {
        // Рассчитываем минимальный радиус, в который пролезет этот колышек.
        return peg?.let { (sqrt((it.getWidth() / 2).pow(2) * 2)) } ?: 0.0
    }
}