package behavioral.state.states

import behavioral.state.ui.Player

//Состояние "готов"
class ReadyState(private val player: Player) : State(player) {
    override fun onLock(): String {
        player.changeState(LockedState(player))
        return "Locked..."
    }

    override fun onNext(): String {
        return "Locked..."
    }

    override fun onPlay(): String {
        val action = player.startPlayback()
        player.changeState(PlayingState(player))
        return action
    }

    override fun onPrevious(): String {
        return "Locked..."
    }
}