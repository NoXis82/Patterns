package generating.factory_method

/**
 * Реализация HTML кнопок
 */
class HtmlButton() : Button {

    override fun render() {
        println("<button>Test Button</button>")
        onClick()
    }

    override fun onClick() {
        println("Click! Button says - 'Hello World!'")
    }
}