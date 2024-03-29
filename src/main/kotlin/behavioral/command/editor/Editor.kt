package behavioral.command.editor

import behavioral.command.commands.*
import java.awt.FlowLayout
import javax.swing.*


//Оболочка текстового редактора
class Editor {
    var textField: JTextArea? = null
    var clipboard: String? = null
    private val history = CommandHistory()


    fun init() {
        val frame = JFrame("Text editor (type & use buttons, Luke!)")
        val content = JPanel()
        frame.contentPane = content
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        content.layout = BoxLayout(content, BoxLayout.Y_AXIS)
        textField = JTextArea()
        textField!!.lineWrap = true
        content.add(textField)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        val ctrlC = JButton("Ctrl+C")
        val ctrlX = JButton("Ctrl+X")
        val ctrlV = JButton("Ctrl+V")
        val ctrlZ = JButton("Ctrl+Z")
        val editor = this
        ctrlC.addActionListener {
            executeCommand(CopyCommand(editor))
        }
        ctrlX.addActionListener {
            executeCommand(CutCommand(editor))
        }
        ctrlV.addActionListener {
            executeCommand(PasteCommand(editor))
        }
        ctrlZ.addActionListener {
            undo()
        }
        buttons.add(ctrlC)
        buttons.add(ctrlX)
        buttons.add(ctrlV)
        buttons.add(ctrlZ)
        content.add(buttons);
        frame.setSize(450, 200)
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }

    private fun executeCommand(command: Command) {
        if (command.execute()) {
            history.push(command)
        }
    }

    private fun undo() {
        if (history.isEmpty()) return
        history.pop()?.undo()
    }

}