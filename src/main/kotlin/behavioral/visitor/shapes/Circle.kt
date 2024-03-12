package behavioral.visitor.shapes

import behavioral.visitor.visitor.Visitor

//Круг
class Circle(
    private val id: Int,
    private val x: Int,
    private val y: Int,
    private val radius: Int
): Dot(id, x, y) {

    override fun accept(visitor: Visitor): String {
        return visitor.visitCircle(this)
    }

    fun getRadius(): Int = radius
}