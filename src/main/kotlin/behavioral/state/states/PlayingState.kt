package behavioral.state.states

import behavioral.state.ui.Player

//Состояние "проигрывание"
class PlayingState(private val player: Player): State(player) {
    override fun onLock(): String {
        player.changeState(LockedState(player))
        player.setCurrentTrackAfterStop()
        return "Stop playing"
    }

    override fun onNext(): String {
        return player.nextTrack()
    }

    override fun onPlay(): String {
        player.changeState(ReadyState(player))
        return "Paused..."
    }

    override fun onPrevious(): String {
        return player.previousTrack()
    }
}