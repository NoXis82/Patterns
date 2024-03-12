package structure.composite.shapes

import java.awt.Color
import java.awt.Graphics

//Круг
class Circle : BaseShape {

    var radius: Int = 0

    constructor(x: Int, y: Int, radius: Int, color: Color) : super(x, y, color) {
        this.radius = radius
    }

    override fun getWidth(): Int = radius * 2

    override fun getHeight(): Int = radius * 2

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.drawOval(x, y, getWidth() - 1, getHeight() - 1)
    }
}