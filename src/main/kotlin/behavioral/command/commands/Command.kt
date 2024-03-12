package behavioral.command.commands

import behavioral.command.editor.Editor

//Абстрактная базовая комманда
abstract class Command(private val editor: Editor) {
    private var backup: String? = null

    fun backup() {
        backup = editor.textField?.text
    }

    fun undo() {
        editor.textField?.text = backup
    }

    abstract fun execute(): Boolean
}