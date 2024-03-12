package behavioral.command.commands

import behavioral.command.editor.Editor

//Команда вырезания
class CutCommand(private val editor: Editor): Command(editor) {

    override fun execute(): Boolean {
        if (editor.textField?.getSelectedText()?.isEmpty() == true) return false
        backup()
        val source = editor.textField!!.text
        editor.clipboard = editor.textField!!.selectedText
        editor.textField!!.text = cutString(source)
        return true
    }

    private fun cutString(source: String): String {
        val start = source.substring(0, editor.textField!!.selectionStart)
        val end = source.substring(editor.textField!!.selectionEnd)
        return start + end
    }
}