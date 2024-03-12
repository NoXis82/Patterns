package generating.abstract_factory.factories

import generating.abstract_factory.button.Button
import generating.abstract_factory.checkbox.Checkbox

/**
 * Абстрактная фабрика знает обо всех (абстрактных) типах продуктов.
 */
interface GUIFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}