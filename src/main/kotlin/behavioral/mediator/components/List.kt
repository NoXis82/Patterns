package behavioral.mediator.components

import behavioral.mediator.mediator.Mediator
import behavioral.mediator.mediator.Note
import javax.swing.DefaultListModel
import javax.swing.JList


//Конкретные компоненты никак не связаны между собой. У них есть только один
//канал общения – через отправку уведомлений посреднику.
@SuppressWarnings("unchecked")
class List(listModel: DefaultListModel<Any>?) : JList<Any>(listModel), Component {
    private var mediator: Mediator? = null
    private var LIST_MODEL: DefaultListModel<Any>? = null

    init {
        this.LIST_MODEL = listModel
        setModel(listModel)
        this.layoutOrientation = VERTICAL
        val thread = Thread(Hide(this))
        thread.start()
    }

    override fun setMediator(mediator: Mediator) {
        this.mediator = mediator
    }

    fun addElement(note: Note) {
        LIST_MODEL?.addElement(note)
        val index = LIST_MODEL!!.size() - 1
        selectedIndex = index
        ensureIndexIsVisible(index)
        mediator?.sendToFilter(LIST_MODEL)
    }

    fun deleteElement() {
        val index = this.selectedIndex
        try {
            LIST_MODEL?.remove(index)
            mediator?.sendToFilter(LIST_MODEL)
        } catch (ignored: ArrayIndexOutOfBoundsException) {
            ignored.printStackTrace()
        }
    }

    fun getCurrentElement(): Note {
        return (selectedValue as Note)
    }

    override fun getName(): String {
        return "List"
    }

    inner class Hide(private val list: List) : Runnable {
        override fun run() {
            while (true) {
                try {
                    Thread.sleep(300)
                } catch (ex: InterruptedException) {
                    ex.printStackTrace()
                }
                if (list.isSelectionEmpty) {
                    mediator?.hideElements(true)
                } else {
                    mediator?.hideElements(false)
                }
            }
        }
    }
}

