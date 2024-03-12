package structure.adapter.round

/**
 * Круглое отверстие совместимо с круглыми колышками
 */
class RoundHole() {
    private var radius: Double = 0.0

    constructor(radius: Double): this() {
        this.radius = radius
    }

    fun getRadius(): Double {
        return radius
    }

    fun fits(peg: RoundPeg): Boolean {
        return (this.getRadius() >= peg.getRadius())
    }
}