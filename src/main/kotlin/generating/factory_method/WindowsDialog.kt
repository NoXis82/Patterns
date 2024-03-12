package generating.factory_method

/**
 * Диалог на элементах операционной системы.
 */
class WindowsDialog(): Dialog() {

    override fun createButton(): Button {
        return WindowsButton()
    }
}