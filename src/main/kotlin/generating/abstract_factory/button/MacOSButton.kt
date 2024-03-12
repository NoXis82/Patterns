package generating.abstract_factory.button

import generating.abstract_factory.button.Button

/**
 * Все семейства продуктов имеют одни и те же вариации (MacOS/Windows).
 * Это вариант кнопки под MacOS.
 */
class MacOSButton() : Button {
    override fun paint() {
        println("You have created MacOSButton.")
    }
}