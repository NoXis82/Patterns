package behavioral.observer.editor

import behavioral.observer.publisher.EventManager
import java.io.File

//Конкретный издатель, изменение которого хотят отслеживать наблюдатели
class Editor() {
    var events: EventManager? = null
    private var file: File? = null

    init {
        events = EventManager("open", "save")
    }

    fun openFile(filePath: String) {
        file = File(filePath)
        file?.let {
            events?.notify("open", it)
        }
    }

    @Throws(Exception::class)
    fun saveFile() {
        file?.let {
            events?.notify("save", it)
        } ?: throw Exception("Please open a file first.")
    }
}