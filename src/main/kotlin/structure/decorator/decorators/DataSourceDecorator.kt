package structure.decorator.decorators

//Базовый декоратор
open class DataSourceDecorator() : DataSource {

    private var wrapper: DataSource? = null

    constructor(source: DataSource) : this() {
        this.wrapper = source
    }

    override fun writeData(data: String) {
        wrapper?.writeData(data)
    }

    override fun readData(): String? {
        return wrapper?.readData()
    }
}