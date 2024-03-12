package generating.abstract_factory

import generating.abstract_factory.button.Button
import generating.abstract_factory.checkbox.Checkbox
import generating.abstract_factory.factories.GUIFactory

/**
 * Код, использующий фабрику, не волнует с какой конкретно фабрикой он работает.
 * Все получатели продуктов работают с продуктами через абстрактный интерфейс.
 */
class Application(private val factory: GUIFactory) {

    private var button: Button? = null
    private var checkbox: Checkbox? = null

    init {
        button = factory.createButton()
        checkbox = factory.createCheckbox()
    }

    fun paint() {
        button?.paint()
        checkbox?.paint()
    }
}