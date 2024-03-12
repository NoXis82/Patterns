package behavioral.observer.listeners

import java.io.File

//Слушатель, записывающий лог операций
class LogOpenListener(private val fileName: String) : EventListener {
    private var log: File? = null

    init {
        log = File(fileName)
    }

    override fun update(eventType: String, file: File) {
        println("Save to log $log: Someone has performed $eventType operation with the following file: ${file.getName()}")
    }
}