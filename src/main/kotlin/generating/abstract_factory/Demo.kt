package generating.abstract_factory

import generating.abstract_factory.factories.MacOSFactory
import generating.abstract_factory.factories.WindowsFactory

/**
 * Приложение выбирает тип и создаёт конкретные фабрики динамически исходя
 * из конфигурации или окружения.
 *
 * Результат выполнения:
 * You create WindowsButton.
 * You created WindowsCheckbox
 */
fun main() {
    val osName = System.getProperty("os.name").lowercase()
    val factory = if (osName.contains("mac")) {
        MacOSFactory()
    } else {
        WindowsFactory()
    }

    val app = Application(factory)
    app.paint()
}
