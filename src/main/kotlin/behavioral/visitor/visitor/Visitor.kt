package behavioral.visitor.visitor

import behavioral.visitor.shapes.*

//Интерфейс посетителя
interface Visitor {
    fun visitDot(dot: Dot): String
    fun visitCircle(circle: Circle): String
    fun visitRectangle(rectangle: Rectangle): String
    fun visitCompoundGraphic(cg: CompoundShape): String
}