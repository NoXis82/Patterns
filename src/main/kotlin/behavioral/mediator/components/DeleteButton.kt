package behavioral.mediator.components

import behavioral.mediator.mediator.Mediator
import java.awt.event.ActionEvent
import javax.swing.JButton

//Конкретные компоненты никак не связаны между собой. У них есть только один
//канал общения – через отправку уведомлений посредни
class DeleteButton() : JButton("Del"), Component {
    private var mediator: Mediator? = null

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    override fun fireActionPerformed(event: ActionEvent?) {
        mediator?.deleteNote()
    }

    override fun getName(): String {
        return "DelButton"
    }
}