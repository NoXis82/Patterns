package behavioral.observer.publisher

import behavioral.observer.listeners.EventListener
import java.io.File

//Базовый издатель
class EventManager(vararg operations: String) {
    private val listeners = hashMapOf<String, MutableList<EventListener>>()

    init {
        operations.forEach { operation ->
            listeners[operation] = arrayListOf()
        }
    }

    fun subscribe(eventType: String, listener: EventListener) {
        val users = listeners[eventType]
        users?.add(listener)
    }

    fun unsubscribe(eventType: String, listener: EventListener) {
        val users = listeners[eventType]
        users?.remove(listener)
    }

    fun notify(eventType: String, file: File) {
        val users = listeners[eventType]
        users?.forEach { listener ->
            listener.update(eventType, file)
        }
    }
}