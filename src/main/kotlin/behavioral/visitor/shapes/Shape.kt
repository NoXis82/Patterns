package behavioral.visitor.shapes

import behavioral.visitor.visitor.Visitor

//Общий интерфейс фигур
interface Shape {
    fun movie(x: Int, y: Int)
    fun draw()
    fun accept(visitor: Visitor): String
}