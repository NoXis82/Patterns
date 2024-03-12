package behavioral.memento.history

import behavioral.memento.commands.Command
import kotlin.math.max
import kotlin.math.min


//История использует снимки и команды
class History() {
    private var history: MutableList<Pair> = arrayListOf()
    private var virtualSize = 0

    private class Pair(private val command: Command, private val memento: Memento) {

        fun getCommand(): Command {
            return command
        }

        fun getMemento(): Memento {
            return memento
        }
    }

    fun push(c: Command?, m: Memento) {
        if (virtualSize != history.size && virtualSize > 0) {
            history = history.subList(0, virtualSize - 1)
        }
        history.add(Pair(c!!, m))
        virtualSize = history.size
    }

    fun undo(): Boolean {
        val pair = getUndo() ?: return false
        println("Undoing: ${pair.getCommand().getName()}")
        pair.getMemento().restore()
        return true
    }

    fun redo(): Boolean {
        val pair: Pair = getRedo() ?: return false
        println("Redoing: ${pair.getCommand().getName()}")
        pair.getMemento().restore()
        pair.getCommand().execute()
        return true
    }

    private fun getUndo(): Pair? {
        if (virtualSize == 0) return null
        virtualSize = max(0.0, (virtualSize - 1).toDouble()).toInt()
        return history[virtualSize]
    }

    private fun getRedo(): Pair? {
        if (virtualSize == history.size) return null
        virtualSize = min(history.size.toDouble(), (virtualSize + 1).toDouble()).toInt()
        return history[virtualSize - 1]
    }
}