package behavioral.memento.editor

import behavioral.memento.commands.ColorCommand
import behavioral.memento.commands.MoveCommand
import java.awt.BorderLayout
import java.awt.Canvas
import java.awt.Color
import java.awt.Graphics
import java.awt.event.*
import java.awt.image.BufferedImage
import javax.swing.*


//Холст
class Canvas() : Canvas() {
    private var frame: JFrame? = null
    private var editor: Editor? = null

    constructor(editor: Editor) : this() {
        this.editor = editor
        createFrame()
        attachKeyboardListeners()
        attachMouseListeners()
        refresh()
    }

    private fun attachMouseListeners() {
        addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent) {
                if ((e.modifiers and KeyEvent.CTRL_MASK) != 0) {
                    when (e.keyCode) {
                        KeyEvent.VK_Z -> editor?.undo()
                        KeyEvent.VK_R -> editor?.redo()
                    }
                }
            }
        })
    }

    private fun attachKeyboardListeners() {
        addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                if (e.button != MouseEvent.BUTTON3) return
                val target = editor?.getShapes()?.getChildAt(e.x, e.y)
                if (target != null) {
                    editor?.execute(ColorCommand(editor!!, Color((Math.random() * 0x1000000).toInt())))
                    repaint()
                }
            }
        })

        addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                if (e.button != MouseEvent.BUTTON1) return
                val target = editor?.getShapes()?.getChildAt(e.x, e.y)
                val ctrl = (e.modifiers and ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK
                if (target == null) {
                    if (!ctrl) {
                        editor?.getShapes()?.unSelect()
                    }
                } else {
                    if (ctrl) {
                        if (target.isSelected()) {
                            target.unSelect()
                        } else {
                            target.select()
                        }
                    } else {
                        if (!target.isSelected()) {
                            editor?.getShapes()?.unSelect()
                        }
                        target.select()
                    }
                }
                repaint()
            }
        })

        val dragger = object : MouseAdapter() {
            var moveCommand: MoveCommand? = null

            override fun mouseDragged(e: MouseEvent) {
                if ((e.modifiersEx and MouseEvent.BUTTON1_DOWN_MASK) != MouseEvent.BUTTON1_DOWN_MASK) return

                if (moveCommand == null) {
                    moveCommand = MoveCommand(editor!!)
                    moveCommand?.start(e.x, e.y)
                }
                moveCommand?.move(e.x, e.y)
                repaint()
            }

            override fun mouseReleased(e: MouseEvent) {
                if (e.button != MouseEvent.BUTTON1 || moveCommand == null) return
                moveCommand?.stop(e.x, e.y)
                editor?.execute(moveCommand!!)
                this.moveCommand = null
                repaint()
            }
        }

        addMouseListener(dragger)
        addMouseMotionListener(dragger)

    }

    private fun createFrame() {
        frame = JFrame()
        frame?.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        frame?.setLocationRelativeTo(null)

        val contentPanel = JPanel()
        val padding = BorderFactory.createEmptyBorder(
            PADDING,
            PADDING,
            PADDING,
            PADDING
        )
        contentPanel.border = padding
        contentPanel.layout = BoxLayout(contentPanel, BoxLayout.Y_AXIS)
        frame?.contentPane = contentPanel

        contentPanel.add(JLabel("Select and drag to move."), BorderLayout.PAGE_END)
        contentPanel.add(JLabel("Right click to change color."), BorderLayout.PAGE_END)
        contentPanel.add(JLabel("Undo: Ctrl+Z, Redo: Ctrl+R"), BorderLayout.PAGE_END)
        contentPanel.add(this)
        frame?.isVisible = true
        contentPanel.background = Color.LIGHT_GRAY
    }

    override fun getWidth(): Int {
        return editor?.let {
            it.getShapes().getX() + it.getShapes().getWidth() + PADDING
        } ?: PADDING
    }

    override fun getHeight(): Int {
        return editor?.let { it.getShapes().getY() + it.getShapes().getHeight() + PADDING } ?: PADDING
    }

    fun refresh() {
        this.setSize(width, height)
        frame?.pack()
    }

    override fun update(g: Graphics) {
        paint(g)
    }

    override fun paint(g: Graphics) {
        val buffer = BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB)
        val ig2 = buffer.createGraphics()
        ig2.background = Color.WHITE
        ig2.clearRect(0, 0, this.width, this.height)
        editor?.getShapes()?.paint(buffer.graphics)
        graphics.drawImage(buffer, 0, 0, null)
    }

    companion object {
        const val PADDING: Int = 10
    }
}