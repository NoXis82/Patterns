package structure.bridge.devices

//ТВ
class Tv(): Device {

    private var on: Boolean = false
    private var volume: Int = 30
    private var channel: Int = 1

    override fun isEnabled(): Boolean = on

    override fun enable() {
        on = true
    }

    override fun disable() {
        on = false
    }

    override fun getVolume(): Int = volume

    override fun setVolume(percent: Int) {

        if (percent > 100) {
            volume = 100
        } else if (volume < 0) {
            volume = 0
        } else {
            volume = percent
        }
    }

    override fun getChannel(): Int = channel

    override fun setChannel(channel: Int) {
        this.channel = channel
    }

    override fun printStatus() {
        val str = buildString {
            append("------------------------------------\n")
            append("I'm TV set.\n")
            if (on) append("I'm enabled\n") else append("I'm disabled\n")
            append("Current volume is $volume %\n")
            append("Current channel is $channel\n")
            append("------------------------------------\n")
        }
        println(str)
    }

}