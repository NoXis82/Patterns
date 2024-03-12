package behavioral.memento.shapes

import java.awt.Color
import java.awt.Graphics


class Dot(
    private val x: Int,
    private val y: Int,
    private val color: Color
) : BaseShape(x, y, color) {

    override fun getWidth(): Int = DOT_SIZE

    override fun getHeight(): Int = DOT_SIZE

    override fun paint(graphics: Graphics) {
        super.paint(graphics)
        graphics.fillRect(x, y, getWidth(), getHeight())
    }

    companion object {
        const val DOT_SIZE: Int = 3
    }
}