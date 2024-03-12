package behavioral.observer

import behavioral.observer.editor.Editor
import behavioral.observer.listeners.EmailNotificationListener
import behavioral.observer.listeners.LogOpenListener

fun main() {
    val editor = Editor()
    editor.events?.subscribe("open", LogOpenListener("/path/to/log/file.txt"))
    editor.events?.subscribe("save", EmailNotificationListener("admin@example.com"))
    try {
        editor.openFile("test.txt")
        editor.saveFile()
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

//Результат выполнения
//Save to log \path\to\log\file.txt: Someone has performed open operation with the following file: test.txt
//Email to admin@example.com: Someone has performed save operation with the following file: test.txt
