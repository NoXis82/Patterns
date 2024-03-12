package behavioral.visitor.shapes

import behavioral.visitor.visitor.Visitor

//Точка
open class Dot(
    private val id: Int,
    private val x: Int,
    private val y: Int
) : Shape {

    override fun movie(x: Int, y: Int) {
        println("Move shape: $x, $y")
    }

    override fun draw() {
        println("Draw shape")
    }

    override fun accept(visitor: Visitor): String {
        return visitor.visitDot(this)
    }

    fun getX(): Int = x

    fun getY(): Int = y

    fun getId(): Int = id
}