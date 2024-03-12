package behavioral.state.states

import behavioral.state.ui.Player

//Общий интерфейс состояний
abstract class State(private val player: Player) {
    //Контекст передаёт себя в конструктор состояния, чтобы состояние могло
    //обращаться к его данным и методам в будущем, если потребуется.

    abstract fun onLock(): String
    abstract fun onNext(): String
    abstract fun onPlay(): String
    abstract fun onPrevious(): String
}