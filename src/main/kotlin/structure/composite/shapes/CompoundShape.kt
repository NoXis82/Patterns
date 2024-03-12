package structure.composite.shapes

import java.awt.Color
import java.awt.Graphics

// Составная фигура
open class CompoundShape : BaseShape {
    protected val children = arrayListOf<Shape>()

    constructor(vararg components: Shape) : super(0, 0, Color.BLACK) {
        add(*components)
    }

    internal fun add(vararg components: Shape) {
        children.addAll(listOf(*components))
    }

    fun remove(child: Shape) {
        children.remove(child)
    }

    fun remove(vararg components: Shape) {
        children.removeAll(listOf(*components).toSet())
    }

    fun clear() {
        children.clear()
    }

    override fun getY(): Int {
        if (children.size == 0) return 0
        var y = children[0].getY()
        for (child in children) {
            if (child.getY() < y) {
                y = child.getY()
            }
        }
        return y
    }

    override fun getWidth(): Int {
        var maxWidth = 0
        val x = getX()
        for (child in children) {
            val childsRelativeX = child.getX() - x
            val childWidth = childsRelativeX + child.getWidth()
            if (childWidth > maxWidth) {
                maxWidth = childWidth
            }
        }

        return maxWidth
    }

    override fun getHeight(): Int {
        var maxHeight = 0
        val y = getY()
        for (child in children) {
            val childsRelativeY = child.getY() - y
            val childHeight = childsRelativeY + child.getHeight()
            if (childHeight > maxHeight) {
                maxHeight = childHeight
            }
        }
        return maxHeight
    }

    override fun move(x: Int, y: Int) {
        for (child in children) {
            child.move(x, y)
        }
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                return true
            }
        }
        return false
    }

    override fun unSelect() {
        super.unSelect()
        for (child in children) {
            child.unSelect()
        }
    }

    fun selectChildAt(x: Int, y: Int): Boolean {
        for (child in children) {
            if (child.isInsideBounds(x, y)) {
                child.select()
                return true
            }
        }
        return false
    }

    override fun paint(graphics: Graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics)
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1)
            disableSelectionStyle(graphics)
        }

        for (child in children) {
            child.paint(graphics)
        }
    }

}