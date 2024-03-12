package structure.decorator.decorators

import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.IOException


//Класс, реализующий прямое чтение и запись данных
class FileDataSource() : DataSource {

    private var name: String? = null

    constructor(name: String) : this() {
        this.name = name
    }

    override fun writeData(data: String) {
        val file = File(name)
        try {
            FileOutputStream(file).use { fos ->
                fos.write(data.toByteArray(), 0, data.length)
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

    override fun readData(): String {
        var buffer: CharArray? = null
        val file = File(name)
        try {
            FileReader(file).use { reader ->
                buffer = CharArray(file.length().toInt())
                reader.read(buffer)
            }
        } catch (ex: IOException) {
            println(ex.message)
        }
        return String(buffer!!)
    }
}