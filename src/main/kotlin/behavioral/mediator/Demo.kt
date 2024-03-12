package behavioral.mediator

import behavioral.mediator.components.*
import behavioral.mediator.components.List
import behavioral.mediator.mediator.Editor
import javax.swing.DefaultListModel

fun main() {
    val mediator = Editor()
    mediator.registerComponent(Title())
    mediator.registerComponent(TextBox())
    mediator.registerComponent(AddButton())
    mediator.registerComponent(DeleteButton())
    mediator.registerComponent(SaveButton())
    mediator.registerComponent(List(DefaultListModel()))
    mediator.registerComponent(Filter())

    mediator.createGUI()
}