package structure.composite.shapes

import java.awt.Color
import java.awt.Graphics

//Точка
class Dot : BaseShape {
    private val DOT_SIZE = 3

    constructor(x: Int, y: Int, color: Color) : super(x, y, color) {

    }

    override fun getWidth(): Int = DOT_SIZE

    override fun getHeight(): Int = DOT_SIZE

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.fillRect(x - 1, y - 1, getWidth(), getHeight())
    }
}