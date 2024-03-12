package structure.decorator.decorators

//Интерфейс, задающий базовые операции чтения и записи данных
interface DataSource {
    fun writeData(data: String)
    fun readData(): String?
}