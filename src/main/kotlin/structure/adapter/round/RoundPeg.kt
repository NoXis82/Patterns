package structure.adapter.round

/**
 * Круглые колышки совместимы с круглыми отверстиями.
 */
open class RoundPeg() {
    private var radius: Double = 0.0

    constructor(radius: Double): this() {
        this.radius = radius
    }

    open fun getRadius(): Double {
        return radius
    }
}