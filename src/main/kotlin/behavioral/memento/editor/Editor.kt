package behavioral.memento.editor

import behavioral.memento.commands.Command
import behavioral.memento.history.History
import behavioral.memento.history.Memento
import behavioral.memento.shapes.CompoundShape
import behavioral.memento.shapes.Shape
import java.io.*
import java.util.*
import javax.swing.JComponent


//Редактор
class Editor() : JComponent() {
    private var canvas: Canvas = Canvas()
    private var allShapes: CompoundShape = CompoundShape()
    private var history: History = History()

    fun loadShapes(vararg shapes: Shape) {
        allShapes.clear()
        allShapes.add(*shapes)
        canvas.refresh()
    }

    fun getShapes(): CompoundShape {
        return allShapes
    }

    fun execute(c: Command) {
        history.push(c, Memento(this))
        c.execute()
    }

    fun undo() {
        if (history.undo()) canvas.repaint()
    }

    fun redo() {
        if (history.redo()) canvas.repaint()
    }

    fun backup(): String {
        try {
            val baos = ByteArrayOutputStream()
            val oos = ObjectOutputStream(baos)
            oos.writeObject(this.allShapes)
            oos.close()
            return Base64.getEncoder().encodeToString(baos.toByteArray())
        } catch (e: IOException) {
            return ""
        }
    }

    fun restore(state: String?) {
        try {
            val data = Base64.getDecoder().decode(state)
            val ois = ObjectInputStream(ByteArrayInputStream(data))
            this.allShapes = (ois.readObject() as CompoundShape)
            ois.close()
        } catch (e: ClassNotFoundException) {
            print("ClassNotFoundException occurred.")
        } catch (e: IOException) {
            print("IOException occurred.")
        }
    }

}