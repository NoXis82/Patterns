package behavioral.memento.shapes

import java.awt.Color
import java.awt.Graphics


class CompoundShape(vararg components: Shape) : BaseShape(0, 0, Color.BLACK) {
    private val children = arrayListOf<Shape>()

    init {
        add(*components)
    }

    fun add(component: Shape) {
        children.add(component)
    }

    fun add(vararg components: Shape) {
        children.addAll(components)
    }

    fun remove(child: Shape) {
        children.remove(child)
    }

    fun remove(vararg components: Shape) {
        children.removeAll(components.toSet())
    }

    fun clear() {
        children.clear()
    }

    override fun getX(): Int {
        if (children.size == 0) return 0
        var x = children[0].getX()
        children.forEach { child ->
            if (child.getX() < x) x = child.getX()
        }
        return x
    }

    override fun getY(): Int {
        if (children.size == 0) return 0
        var y = children[0].getY()
        children.forEach { child ->
            if (child.getY() < y) y = child.getY()
        }
        return y
    }

    override fun getWidth(): Int {
        var maxWidth = 0
        val x = getX()
        children.forEach { child ->
            val childsRelativeX = child.getX() - x
            val childWidth = childsRelativeX + child.getWidth()
            if (childWidth > maxWidth) maxWidth = childWidth
        }

        return maxWidth
    }

    override fun getHeight(): Int {
        var maxHeight = 0
        val y = getY()
        children.forEach { child ->
            val childsRelativeY = child.getY() - y
            val childHeight = childsRelativeY + child.getHeight()
            if (childHeight > maxHeight) maxHeight = childHeight
        }

        return maxHeight
    }

    override fun drag() {
        children.forEach { child ->
            child.drag()
        }
    }

    override fun drop() {
        children.forEach { child ->
            child.drop()
        }
    }

    override fun moveTo(x: Int, y: Int) {
        children.forEach { child ->
            child.moveTo(x, y)
        }
    }

    override fun moveBy(x: Int, y: Int) {
        children.forEach { child ->
            child.moveBy(x, y)
        }
    }

    override fun isInsideBounds(x: Int, y: Int): Boolean {
        children.forEach { child ->
            if (child.isInsideBounds(x, y)) return true
        }
        return false
    }

    override fun setColor(color: Color) {
        super.setColor(color)
        children.forEach { child ->
            child.setColor(color)
        }
    }

    override fun unSelect() {
        super.unSelect()
        children.forEach { child ->
            child.unSelect()
        }
    }

    fun getChildAt(x: Int, y: Int): Shape? {
        children.forEach { child ->
            if (child.isInsideBounds(x, y)) {
                return child
            }
        }

        return null
    }

    fun selectChildAt(x: Int, y: Int): Boolean {
        val child = getChildAt(x, y)
        if (child != null) {
            child.select()
            return true
        }
        return false
    }

    fun getSelected(): List<Shape> {
        val selected: MutableList<Shape> = arrayListOf()
        children.forEach { child ->
            if (child.isSelected()) {
                selected.add(child)
            }
        }

        return selected
    }

    override fun paint(graphics: Graphics) {
        if (isSelected()) {
            enableSelectionStyle(graphics)
            graphics.drawRect(getX() - 1, getY() - 1, getWidth() + 1, getHeight() + 1)
            disableSelectionStyle(graphics)
        }
        children.forEach { child ->
            child.paint(graphics)
        }
    }
}

