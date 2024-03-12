package structure.bridge.remotes

import structure.bridge.devices.Device

/**
 * Стандартный пульт
 */
open class BasicRemote() : Remote {
    protected var device: Device? = null

    constructor(device: Device) : this() {
        this.device = device
    }


    override fun power() {
        println("Remote: power toggle")
        if (device?.isEnabled() == true) {
            device?.disable()
        } else {
            device?.enable()
        }
    }

    override fun volumeDown() {
        println("Remote: volume down")
        device?.setVolume(device!!.getVolume() - 10)
    }

    override fun volumeUp() {
        println("Remote: volume up")
        device?.setVolume(device!!.getVolume() + 10)
    }

    override fun channelDown() {
        println("Remote: channel down")
        device?.setChannel(device!!.getChannel() - 1)
    }

    override fun channelUp() {
        println("Remote: channel up")
        device?.setChannel(device!!.getChannel() + 1)
    }
}