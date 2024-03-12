package generating.factory_method

import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants

/**
 * Реализация нативных кнопок операционной системы.
 */
class WindowsButton() : Button {

    private val panel = JPanel()
    private val frame = JFrame()
    private var button: JButton? = null

    override fun render() {
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        val label = JLabel("Hello world!")
        label.apply {
            isOpaque = true
            background = Color(235, 233, 126)
            font = Font("Dialog", Font.BOLD, 44)
            horizontalAlignment = SwingConstants.CENTER
        }
        panel.layout = FlowLayout(FlowLayout.CENTER)
        frame.contentPane.add(panel)
        panel.add(label)
        onClick()
        panel.add(button)

        frame.setSize(320, 200) //.size = Dimension(800, 600)
        frame.isVisible = true
        onClick()
    }

    override fun onClick() {
        button = JButton("Exit")
        button?.addActionListener {
            frame.isVisible = false
            System.exit(0)
        }
    }
}