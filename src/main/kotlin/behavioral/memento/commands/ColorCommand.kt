package behavioral.memento.commands

import behavioral.memento.editor.Editor
import java.awt.Color

//Команда смены цвета
class ColorCommand(private val editor: Editor, private val color: Color) : Command {

    override fun getName(): String {
        return "Colorize: $color"
    }

    override fun execute() {
        editor.getShapes().getSelected().forEach { child ->
            child.setColor(color)
        }
    }
}