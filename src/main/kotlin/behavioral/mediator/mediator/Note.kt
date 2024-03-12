package behavioral.mediator.mediator

//Класс заметок.
class Note() {
    private var name: String = "New note"
    private var text: String? = null

    fun setName(name: String) {
        this.name = name
    }

    fun setText(text: String) {
        this.text = text
    }

    fun getName(): String {
        return name
    }

    fun getText(): String? {
        return text
    }

    override fun toString(): String {
        return name
    }
}