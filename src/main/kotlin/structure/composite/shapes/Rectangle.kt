package structure.composite.shapes

import java.awt.Color
import java.awt.Graphics

// Четырёхугольник
class Rectangle : BaseShape {
    @get:JvmName("getWidth()")
    var width: Int = 0
    @get:JvmName("getHeight()")
    var height: Int = 0

    constructor(x: Int, y: Int, width: Int, height: Int, color: Color) : super(x, y, color) {
        this.width = width
        this.height = height
    }

    override fun getWidth(): Int = width

    override fun getHeight(): Int = height

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawRect(x, y, getWidth() - 1, getHeight() - 1)
    }
}