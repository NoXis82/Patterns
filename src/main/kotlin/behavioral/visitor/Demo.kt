package behavioral.visitor

import behavioral.visitor.shapes.*
import behavioral.visitor.visitor.XMLExportVisitor



fun main() {
    val dot = Dot(1, 10, 55)
    val circle = Circle(2, 23, 15, 10)
    val rectangle = Rectangle(3, 10, 17, 20, 30)

    val compoundShape = CompoundShape(4)
    compoundShape.addShape(dot)
    compoundShape.addShape(circle)
    compoundShape.addShape(rectangle)

    val c = CompoundShape(5)
    c.addShape(dot)
    compoundShape.addShape(c)

    export(circle)
    export(compoundShape)
}

private fun export(vararg shapes: Shape) {
    val exportVisitor = XMLExportVisitor()
    println(exportVisitor.export(*shapes))
}
//Результат выполнения
//<?xml version="1.0" encoding="utf-8"?>
//<circle>
//<id>2</id>
//<x>23</x>
//<y>15</y>
//<radius>10</radius>
//</circle>

//<?xml version="1.0" encoding="utf-8"?>
//<compound_graphic>
//<id>4</id>
//<dot>
//<id>1</id>
//<x>10</x>
//<y>55</y>
//</dot>
//<circle>
//<id>2</id>
//<x>23</x>
//<y>15</y>
//<radius>10</radius>
//</circle>
//<rectangle>
//<id>3</id>
//<x>10</x>
//<y>17</y>
//<width>20</width>
//<height>30</height>
//</rectangle>
//<compound_graphic>
//<id>5</id>
//<dot>
//<id>1</id>
//<x>10</x>
//<y>55</y>
//</dot>
//</compound_graphic>
//</compound_graphic>