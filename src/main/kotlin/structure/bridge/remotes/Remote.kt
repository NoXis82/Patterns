package structure.bridge.remotes

/**
 * Общий интерфейс всех пультов ДУ
 */
interface Remote {
    fun power()
    fun volumeDown()
    fun volumeUp()
    fun channelDown()
    fun channelUp()
}