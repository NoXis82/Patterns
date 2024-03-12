package structure.decorator

import structure.decorator.decorators.CompressionDecorator
import structure.decorator.decorators.EncryptionDecorator
import structure.decorator.decorators.FileDataSource


fun main() {
    val salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000"
    val encoded = CompressionDecorator(
        EncryptionDecorator(FileDataSource("OutputDemoDecorator.txt"))
    )
    encoded.writeData(salaryRecords);
    val plain = FileDataSource("OutputDemoDecorator.txt")
    println("- Input ----------------")
    println(salaryRecords)
    println("- Encoded --------------")
    println(plain.readData())
    println("- Decoded --------------")
    println(encoded.readData())
}