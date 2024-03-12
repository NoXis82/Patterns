package behavioral.state.ui

import behavioral.state.states.ReadyState
import behavioral.state.states.State


//Проигрыватель
class Player() {
    private var state: State? = null
    private var playing = false
    private var playlist = arrayListOf<String>()
    private var currentTrack: Int = 0

    init {
        this.state = ReadyState(this)
        setPlaying(true)
        for (i in 1..12) {
            playlist.add("Track $i")
        }
    }

    fun setPlaying(playing: Boolean) {
        this.playing = playing
    }

    fun isPlaying(): Boolean {
        return playing
    }

    fun changeState(state: State) {
        this.state = state
    }

    fun getState(): State? {
        return state
    }

    fun startPlayback(): String {
        return "Playback ${playlist[currentTrack]}"
    }

    fun setCurrentTrackAfterStop() {
        this.currentTrack = 0
    }

    fun nextTrack(): String {
        currentTrack++
        if (currentTrack > playlist.size - 1) {
            currentTrack = 0
        }
        return "Playback ${playlist[currentTrack]}"
    }

    fun previousTrack(): String {
        currentTrack--
        if (currentTrack < 0) {
            currentTrack = playlist.size - 1
        }
        return "Playback ${playlist[currentTrack]}"
    }
}