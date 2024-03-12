package behavioral.memento.commands

import behavioral.memento.editor.Editor

//Команда перемещения
class MoveCommand(private val editor: Editor) : Command {
    private var startX: Int = 0
    private var startY: Int = 0
    private var endX: Int = 0
    private var endY: Int = 0

    override fun getName(): String {
        return "Move by X:${endX - startX} Y:${endY - startY}"
    }

    fun start(x: Int, y: Int) {
        startX = x
        startY = y
        editor.getShapes().getSelected().forEach { child ->
            child.drag()
        }
    }

    fun move(x: Int, y: Int) {
        editor.getShapes().getSelected().forEach { child ->
            child.moveTo(x - startX, y - startY)
        }
    }

    fun stop(x: Int, y: Int) {
        endX = x
        endY = y
        editor.getShapes().getSelected().forEach { child ->
            child.drop()
        }
    }

    override fun execute() {
        editor.getShapes().getSelected().forEach { child ->
            child.moveBy(endX - startX, endY - startY)
        }
    }
}