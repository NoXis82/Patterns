package generating.abstract_factory.factories

import generating.abstract_factory.button.Button
import generating.abstract_factory.button.WindowsButton
import generating.abstract_factory.checkbox.Checkbox
import generating.abstract_factory.checkbox.WindowsCheckbox

/**
 * Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
class WindowsFactory() : GUIFactory {
    override fun createButton(): Button {
        return WindowsButton()
    }

    override fun createCheckbox(): Checkbox {
        return WindowsCheckbox()
    }
}