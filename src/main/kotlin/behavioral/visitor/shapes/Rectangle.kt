package behavioral.visitor.shapes

import behavioral.visitor.visitor.Visitor

//Четырехугольник
class Rectangle(
    private val id: Int,
    private val x: Int,
    private val y: Int,
    private val width: Int,
    private val height: Int
) : Shape {


    override fun movie(x: Int, y: Int) {
        println("Move shape: $x, $y")
    }

    override fun draw() {
        println("Draw shape")
    }

    override fun accept(visitor: Visitor): String {
        return visitor.visitRectangle(this)
    }

    fun getX(): Int = x

    fun getY(): Int = y

    fun getId(): Int = id

    fun getWidth(): Int = width

    fun getHeight(): Int = height
}