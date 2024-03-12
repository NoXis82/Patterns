package behavioral.mediator.mediator

import behavioral.mediator.components.*
import behavioral.mediator.components.List
import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import java.awt.Font
import javax.swing.*
import javax.swing.border.LineBorder


//Конкретный посредник. Все связи между конкретными компонентами переехали в
//код посредника. Он получает извещения от своих компонентов и знает как на них
//реагировать.
class Editor() : Mediator {
    private var title: Title? = null
    private var textBox: TextBox? = null
    private var add: AddButton? = null
    private var del: DeleteButton? = null
    private var save: SaveButton? = null
    private var list: List? = null
    private var filter: Filter? = null

    private var titleLabel = JLabel("Title:")
    private var textLabel = JLabel("Text:")
    private var label = JLabel("Add or select existing note to proceed...")

    //Здесь происходит регистрация компонентов посредником.
    override fun registerComponent(component: Component) {
        component.setMediator(this)
        when (component.getName()) {
            "AddButton" -> {
                add = component as AddButton
                //return
            }

            "DelButton" -> {
                del = component as DeleteButton
            }

            "Filter" -> {
                filter = component as Filter
            }

            "List" -> {
                list = component as List
                this.list?.addListSelectionListener {
                    val note = list?.selectedValue as? Note
                    if (note != null) {
                        getInfoFromList(note)
                    } else {
                        clear()
                    }
                }
            }

            "SaveButton" -> {
                save = component as SaveButton
            }

            "TextBox" -> {
                textBox = component as TextBox
            }

            "Title" -> {
                title = component as Title
            }
        }
    }


    //Разнообразные методы общения с компонентами.
    override fun addNewNote(note: Note) {
        title?.text = ""
        textBox?.text = ""
        list?.addElement(note)
    }

    override fun deleteNote() {
        list?.deleteElement()
    }

    override fun getInfoFromList(note: Note) {
        title?.text = note.getName().replace('*', ' ')
        textBox?.text = note.getText()
    }

    override fun saveChanges() {
        try {
            val note = list?.selectedValue as? Note
            note?.setName(title!!.text)
            note?.setText(textBox!!.text)
            list?.repaint()
        } catch (ignored: NullPointerException) {
            ignored.printStackTrace()
        }
    }

    override fun markNote() {
        try {
            val note = list?.getCurrentElement()
            val name = note?.getName()
            if (name?.endsWith("*") == false) {
                note.setName(note.getName() + "*")
            }
            list?.repaint()
        } catch (ignored: NullPointerException) {
            ignored.printStackTrace()
        }
    }

    override fun clear() {
        title?.text = ""
        textBox?.text = ""
    }

    override fun sendToFilter(listModel: ListModel<Any>?) {
        filter?.setLIst(listModel)
    }

    @SuppressWarnings("unchecked")
    override fun setElementsList(list: ListModel<Any>) {
        this.list?.model = list
        this.list?.repaint()
    }

    override fun hideElements(flag: Boolean) {
        titleLabel.isVisible = !flag
        textLabel.isVisible = !flag
        title?.isVisible = !flag
        textBox?.isVisible = !flag
        save?.isVisible = !flag
        label?.isVisible = flag
    }

    override fun createGUI() {
        val notes = JFrame("Notes")
        notes.setSize(960, 600)
        notes.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        val left = JPanel()
        left.border = LineBorder(Color.BLACK)
        left.setSize(320, 600)
        left.layout = BoxLayout(left, BoxLayout.Y_AXIS)
        val filterPanel = JPanel()
        filterPanel.add(JLabel("Filter:"))
        filter?.columns = 20
        filterPanel.add(filter)
        filterPanel.preferredSize = Dimension(280, 40)
        val listPanel = JPanel()
        list?.fixedCellWidth = 260
        listPanel.setSize(320, 470)
        val scrollPane = JScrollPane(list)
        scrollPane.preferredSize = Dimension(275, 410)
        listPanel.add(scrollPane)
        val buttonPanel = JPanel()
        add?.preferredSize = Dimension(85, 25)
        buttonPanel.add(add)
        del?.preferredSize = Dimension(85, 25)
        buttonPanel.add(del)
        buttonPanel.layout = FlowLayout()
        left.add(filterPanel)
        left.add(listPanel)
        left.add(buttonPanel)
        val right = JPanel()
        right.layout = null
        right.setSize(640, 600)
        right.setLocation(320, 0)
        right.border = LineBorder(Color.BLACK)
        titleLabel.setBounds(20, 4, 50, 20)
        title?.setBounds(60, 5, 555, 20)
        textLabel.setBounds(20, 4, 50, 130)
        textBox?.border = LineBorder(Color.DARK_GRAY)
        textBox?.setBounds(20, 80, 595, 410)
        save?.setBounds(270, 535, 80, 25)
        label.font = Font("Verdana", Font.PLAIN, 22)
        label.setBounds(100, 240, 500, 100)
        right.add(label)
        right.add(titleLabel)
        right.add(title)
        right.add(textLabel)
        right.add(textBox)
        right.add(save)
        notes.layout = null
        notes.contentPane.add(left)
        notes.contentPane.add(right)
        notes.isResizable = false
        notes.setLocationRelativeTo(null)
        notes.isVisible = true
    }
}