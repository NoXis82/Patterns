package behavioral.command.commands

import java.util.*


//История команд
class CommandHistory {
    private val history = Stack<Command>()

    fun push(c: Command?) {
        history.push(c)
    }

    fun pop(): Command? {
        return history.pop()
    }

    fun isEmpty(): Boolean {
        return history.isEmpty()
    }

}