package behavioral.command.commands

import behavioral.command.editor.Editor

//Команда копирования
class CopyCommand(private val editor: Editor): Command(editor) {

    override fun execute(): Boolean {
        editor.clipboard = editor.textField?.selectedText
        return false
    }
}