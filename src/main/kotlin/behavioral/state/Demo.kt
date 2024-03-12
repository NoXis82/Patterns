package behavioral.state

import behavioral.state.ui.Player
import behavioral.state.ui.UI

fun main() {
    val player = Player()
    val ui = UI(player)
    ui.init()
}