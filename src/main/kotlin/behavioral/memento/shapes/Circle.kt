package behavioral.memento.shapes

import java.awt.Color
import java.awt.Graphics

class Circle(private val x: Int, private val y: Int, color: Color, var radius: Int) : BaseShape(x, y, color) {

    override fun getWidth(): Int = radius * 2

    override fun getHeight(): Int = radius * 2

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1)
    }
}