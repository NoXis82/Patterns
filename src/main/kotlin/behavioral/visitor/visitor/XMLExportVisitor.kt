package behavioral.visitor.visitor

import behavioral.visitor.shapes.*
import java.lang.StringBuilder

//Конкретный посетитель
class XMLExportVisitor() : Visitor {

    fun export(vararg shapes: Shape): String {
        val sb = StringBuilder()
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "\n")
        shapes.forEach { shape ->
            sb.append(shape.accept(this)).append("\n")
        }
        return sb.toString()
    }


    override fun visitDot(dot: Dot): String {
        return "<dot>" + "\n" +
                "    <id>" + dot.getId() + "</id>" + "\n" +
                "    <x>" + dot.getX() + "</x>" + "\n" +
                "    <y>" + dot.getY() + "</y>" + "\n" +
                "</dot>"
    }

    override fun visitCircle(circle: Circle): String {
        return "<circle>" + "\n" +
                "    <id>" + circle.getId() + "</id>" + "\n" +
                "    <x>" + circle.getX() + "</x>" + "\n" +
                "    <y>" + circle.getY() + "</y>" + "\n" +
                "    <radius>" + circle.getRadius() + "</radius>" + "\n" +
                "</circle>"
    }

    override fun visitRectangle(rectangle: Rectangle): String {
        return "<rectangle>" + "\n" +
                "    <id>" + rectangle.getId() + "</id>" + "\n" +
                "    <x>" + rectangle.getX() + "</x>" + "\n" +
                "    <y>" + rectangle.getY() + "</y>" + "\n" +
                "    <width>" + rectangle.getWidth() + "</width>" + "\n" +
                "    <height>" + rectangle.getHeight() + "</height>" + "\n" +
                "</rectangle>"
    }

    override fun visitCompoundGraphic(cg: CompoundShape): String {
        return "<compound_graphic>" + "\n" +
                "   <id>" + cg.getId() + "</id>" + "\n" +
                _visitCompoundGraphic(cg) +
                "</compound_graphic>"
    }

    private fun _visitCompoundGraphic(cg: CompoundShape): String {
        val sb = StringBuilder()
        cg.children.forEach { shape ->
            var obj = shape.accept(this)
            obj = "    " + obj.replace("\n", "\n    ") + "\n"
            sb.append(obj)
        }
        return sb.toString()
    }

}