package structure.composite.shapes

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D


// Абстрактная фигура с базовым функционалом
abstract class BaseShape() : Shape {
    @get:JvmName("getX()")
    var x = 0
    @get:JvmName("getY()")
    var y = 0
    var color: Color? = null
    private var selected = false

    constructor(x: Int, y: Int, color: Color) : this() {
        this.x = x
        this.y = y
        this.color = color
    }

    override fun getX(): Int = x

    override fun getY(): Int = y

    override fun getWidth(): Int = 0

    override fun getHeight(): Int = 0

    override fun move(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        return x > getX() && x < (getX() + getWidth()) &&
                y > getY() && y < (getY() + getHeight())
    }

    override fun select() {
        selected = true
    }

    override fun unSelect() {
        selected = false
    }

    override fun isSelected(): Boolean = selected

    override fun paint(graphics: Graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics);
        } else {
            disableSelectionStyle(graphics);
        }
        // ...
    }

    protected fun enableSelectionStyle(graphics: Graphics) {
        graphics.color = Color.LIGHT_GRAY
        val g2 = graphics as Graphics2D
        val dash1 = floatArrayOf(2.0f)
        g2.stroke = BasicStroke(
            1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            2.0f, dash1, 0.0f
        )
    }

    protected fun disableSelectionStyle(graphics: Graphics) {
        graphics.color = color
        val g2 = graphics as Graphics2D
        g2.stroke = BasicStroke()
    }
}