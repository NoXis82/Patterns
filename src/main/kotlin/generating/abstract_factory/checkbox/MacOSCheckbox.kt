package generating.abstract_factory.checkbox

/**
 * Все семейства продуктов имеют одинаковые вариации (MacOS/Windows).
 * Вариация чекбокса под MacOS.
 */
class MacOSCheckbox() : Checkbox {
    override fun paint() {
        println("You have created MacOSCheckbox.")
    }
}