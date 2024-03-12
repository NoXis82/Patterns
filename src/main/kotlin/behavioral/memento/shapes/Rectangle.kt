package behavioral.memento.shapes

import java.awt.Color
import java.awt.Graphics

class Rectangle(
    private val x: Int,
    private val y: Int,
    private val color: Color,
    private val width: Int,
    private val height: Int
) : BaseShape(x, y, color) {

    override fun getWidth(): Int = width

    override fun getHeight(): Int = height

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawRect(x, y, getWidth() - 1, getHeight() - 1)
    }

}