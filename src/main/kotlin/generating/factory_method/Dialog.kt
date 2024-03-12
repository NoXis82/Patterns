package generating.factory_method

/**
 * Базовый класс фабрики. Заметьте, что "фабрика" – это всего лишь
 * дополнительная роль для класса. Он уже имеет какую-то бизнес-логику, в
 * которой требуется создание разнообразных продуктов.
 */
abstract class Dialog {

    fun renderWindow() {
        // ... остальной код диалога ...
        val okButton = createButton()
        okButton.render()
    }

    abstract fun createButton(): Button
}