package generating.abstract_factory.checkbox

/**
 * Все семейства продуктов имеют одинаковые вариации (MacOS/Windows).
 * Вариация чекбокса под Windows.
 */
class WindowsCheckbox() : Checkbox {
    override fun paint() {
        println("You have created WindowsCheckbox.")
    }
}