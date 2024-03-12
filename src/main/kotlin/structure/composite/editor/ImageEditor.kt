package structure.composite.editor

import structure.composite.shapes.CompoundShape
import structure.composite.shapes.Shape
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.BorderFactory
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants


//Редактор фигур
class ImageEditor() {
    private var canvas: EditorCanvas? = null
    private var allShapes: CompoundShape? = null//CompoundShape()

    init {
        canvas = EditorCanvas()
        allShapes = CompoundShape()
    }

    fun loadShapes(vararg shapes: Shape) {
        allShapes?.clear()
        allShapes?.add(*shapes)
        canvas?.refresh()
    }

    private inner class EditorCanvas() : Canvas() {
        val frame: JFrame = JFrame()
        private val PADDING = 10

        init {
            createFrame()
            refresh()
            addMouseListener(object : MouseAdapter() {
                override fun mousePressed(e: MouseEvent) {
                    allShapes?.unSelect();
                    allShapes?.selectChildAt(e.x, e.y);
                    e.component.repaint();
                }
            })
        }

        private fun createFrame() {
            frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
            frame.setLocationRelativeTo(null)
            val contentPanel = JPanel()
            val padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING)
            contentPanel.border = padding
            frame.contentPane = contentPanel

            frame.add(this)
            frame.isVisible = true
            frame.contentPane.background = Color.LIGHT_GRAY
        }

        override fun getWidth(): Int {
            return allShapes?.let {
                it.getX() + it.getWidth() + PADDING
            } ?: PADDING

        }

        override fun getHeight(): Int {
            return allShapes?.let {
                it.getY() + it.getHeight() + PADDING
            } ?: PADDING
        }

        fun refresh() {
            this.setSize(width, height);
            frame.pack();
        }

        override fun paint(graphics: Graphics) {
            allShapes?.paint(graphics)
        }
    }
}