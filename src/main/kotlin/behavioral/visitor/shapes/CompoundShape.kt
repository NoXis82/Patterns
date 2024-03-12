package behavioral.visitor.shapes

import behavioral.visitor.visitor.Visitor

//Составная фигура
class CompoundShape(private val id: Int): Shape {
    val children = arrayListOf<Shape>()

    override fun movie(x: Int, y: Int) {
        println("Move shape: $x, $y")
    }

    override fun draw() {
        println("Draw shape")
    }

    override fun accept(visitor: Visitor): String {
        return visitor.visitCompoundGraphic(this)
    }

    fun getId(): Int = id

    fun addShape(shape: Shape) {
        children.add(shape)
    }
}