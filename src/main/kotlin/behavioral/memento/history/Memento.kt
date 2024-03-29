package behavioral.memento.history

import behavioral.memento.editor.Editor

//Снимок
class Memento(private val editor: Editor) {
    private val backup: String = editor.backup()

    fun restore() {
        editor.restore(backup)
    }
}