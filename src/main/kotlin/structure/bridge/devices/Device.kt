package structure.bridge.devices

/**
 * Общий интерфейс всех устройств
 */
interface Device {
    fun isEnabled(): Boolean
    fun enable()
    fun disable()
    fun getVolume(): Int
    fun setVolume(percent: Int)
    fun getChannel(): Int
    fun setChannel(channel: Int)
    fun printStatus()
}