package generating.abstract_factory.factories

import generating.abstract_factory.button.Button
import generating.abstract_factory.button.MacOSButton
import generating.abstract_factory.checkbox.Checkbox
import generating.abstract_factory.checkbox.MacOSCheckbox

/**
 * Каждая конкретная фабрика знает и создаёт только продукты своей вариации.
 */
class MacOSFactory() : GUIFactory {
    override fun createButton(): Button {
        return MacOSButton()
    }

    override fun createCheckbox(): Checkbox {
        return MacOSCheckbox()
    }
}