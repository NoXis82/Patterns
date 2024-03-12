package structure.bridge

import structure.bridge.devices.Device
import structure.bridge.devices.Radio
import structure.bridge.devices.Tv
import structure.bridge.remotes.AdvancedRemote
import structure.bridge.remotes.BasicRemote

fun main() {
    testDevice(Tv())
    testDevice(Radio())
}

private fun testDevice(device: Device) {
    println("Tests with basic remote.")
    val basicRemote = BasicRemote(device)
    basicRemote.power()
    device.printStatus()

    println("Tests with advanced remote.")
    val advancedRemote = AdvancedRemote(device)
    advancedRemote.power()
    advancedRemote.mute()
    device.printStatus()
}
//Результат выполнения
//Tests with basic remote.
//Remote: power toggle
//------------------------------------
//| I'm TV set.
//| I'm enabled
//| Current volume is 30%
//| Current channel is 1
//------------------------------------
//
//Tests with advanced remote.
//Remote: power toggle
//Remote: mute
//------------------------------------
//| I'm TV set.
//| I'm disabled
//| Current volume is 0%
//| Current channel is 1
//------------------------------------
//
//Tests with basic remote.
//Remote: power toggle
//------------------------------------
//| I'm radio.
//| I'm enabled
//| Current volume is 30%
//| Current channel is 1
//------------------------------------
//
//Tests with advanced remote.
//Remote: power toggle
//Remote: mute
//------------------------------------
//| I'm radio.
//| I'm disabled
//| Current volume is 0%
//| Current channel is 1
//------------------------------------