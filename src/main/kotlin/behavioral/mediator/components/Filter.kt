package behavioral.mediator.components

import behavioral.mediator.mediator.Mediator
import behavioral.mediator.mediator.Note
import java.awt.event.KeyEvent
import javax.swing.DefaultListModel
import javax.swing.JTextField
import javax.swing.ListModel


//Конкретные компоненты никак не связаны между собой. У них есть только один
//канал общения – через отправку уведомлений посреднику.
class Filter(): JTextField(), Component {
    private var mediator: Mediator? = null
    private var listModel: ListModel<Any>? = null

    override fun setMediator(mediator: Mediator) {
       this.mediator = mediator
    }

    override fun processComponentKeyEvent(e: KeyEvent?) {
        val start = getText()
        searchElements(start)
    }

    fun setLIst(listModel: ListModel<Any>?) {
        this.listModel = listModel
    }

    private fun searchElements(s: String) {
        if (listModel == null) return
        if (s == "") {
            mediator?.setElementsList(listModel!!)
            return
        }
        val notes = arrayListOf<Note>()
        for (i in 0 until listModel!!.size) {
            notes.add((listModel!!.getElementAt(i) as Note))
        }
        val listModel = DefaultListModel<Any>()
        for (note in notes) {
            if (note.getName().contains(s)) {
                listModel.addElement(note)
            }
        }
        mediator?.setElementsList(listModel)
    }

    override fun getName(): String {
        return "Filter"
    }

}