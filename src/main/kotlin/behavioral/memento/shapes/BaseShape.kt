package behavioral.memento.shapes

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D


open class BaseShape() : Shape {

    private var dx: Int = 0
    private var dy: Int = 0
    private var selected: Boolean = false
    private var x: Int = 0
    private var y: Int = 0
    private var color: Color? = null

    constructor(x: Int, y: Int, color: Color) : this() {
        this.x = x
        this.y = y
        this.color = color
    }

    override fun getX(): Int = x

    override fun getY(): Int = y

    override fun getWidth(): Int = 0

    override fun getHeight(): Int = 0

    override fun drag() {
        dx = x
        dy = y
    }

    override fun drop() {
        this.x = dx
        this.y = dy
    }

    override fun moveTo(x: Int, y: Int) {
        this.x = dx + x
        this.y = dy + y
    }

    override fun moveBy(x: Int, y: Int) {
        this.x += x
        this.y += y
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        return x > getX() && x < (getX() + getWidth()) &&
                y > getY() && y < (getY() + getHeight())
    }

    override fun getColor(): Color? {
        return color
    }

    override fun setColor(color: Color) {
        this.color = color
    }

    override fun select() {
        selected = true
    }

    override fun unSelect() {
        selected = false
    }

    override fun isSelected(): Boolean = selected

    fun enableSelectionStyle(graphics: Graphics) {
        graphics.color = Color.LIGHT_GRAY
        val g2 = graphics as Graphics2D
        val dash1 = floatArrayOf(2.0f)
        g2.stroke = BasicStroke(
            1.0f,
            BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER,
            2.0f,
            dash1,
            0.0f
        )
    }

    fun disableSelectionStyle(graphics: Graphics) {
        graphics.color = color
        val g2 = graphics as Graphics2D
        g2.stroke = BasicStroke()
    }

    override fun paint(graphics: Graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics)
        } else {
            disableSelectionStyle(graphics)
        }
    }
    // ...
}