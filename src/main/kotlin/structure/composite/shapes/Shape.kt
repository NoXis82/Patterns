package structure.composite.shapes

import java.awt.Graphics

// Общий интерфейс фигур
interface Shape {
    fun getX(): Int
    fun getY(): Int
    fun getWidth(): Int
    fun getHeight(): Int
    fun move(x: Int, y: Int)
    fun isInsideBounds(x: Int, y: Int): Boolean
    fun select()
    fun unSelect()
    fun isSelected(): Boolean
    fun paint(graphics: Graphics)
}