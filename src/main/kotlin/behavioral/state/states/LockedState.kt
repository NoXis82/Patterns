package behavioral.state.states

import behavioral.state.ui.Player

//Состояние "заблокирован"
class LockedState(private val player: Player) : State(player) {

    init {
        player.setPlaying(false)
    }

    override fun onLock(): String {
        if (player.isPlaying()) {
            player.changeState(ReadyState(player))
            return "Stop playing"
        } else {
            return "Locked..."
        }
    }

    override fun onNext(): String {
        return "Locked..."
    }

    override fun onPlay(): String {
        player.changeState(ReadyState(player))
        return "Ready"
    }

    override fun onPrevious(): String {
        return "Locked..."
    }
}