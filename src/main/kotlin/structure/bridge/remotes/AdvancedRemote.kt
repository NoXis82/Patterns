package structure.bridge.remotes

import structure.bridge.devices.Device

/**
 * Улучшенный пульт
 */
class AdvancedRemote() : BasicRemote() {

    constructor(device: Device) : this() {
        super.device = device
    }

    fun mute() {
        println("Remote: mute")
        device?.setVolume(0)
    }
}