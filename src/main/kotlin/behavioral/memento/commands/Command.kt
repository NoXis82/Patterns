package behavioral.memento.commands

//Интерфейс команд
interface Command {
    fun getName(): String
    fun execute()
}