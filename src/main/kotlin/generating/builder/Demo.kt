package generating.builder

import generating.builder.builders.CarBuilder
import generating.builder.builders.CarManualBuilder
import generating.builder.director.Director

fun main() {

    val director = Director()

    // Директор получает объект конкретного строителя от клиента
    // (приложения). Приложение само знает какой строитель использовать,
    // чтобы получить нужный продукт.
    val builder = CarBuilder()
    director.constructSportsCar(builder)

    // Готовый продукт возвращает строитель, так как Директор чаще всего не
    // знает и не зависит от конкретных классов строителей и продуктов.
    val car = builder.getResult()
    println("Car built:")
    println("${car.getCarType()}")

    val manualBuilder = CarManualBuilder()
    // Директор может знать больше одного рецепта строительства.
    director.constructSportsCar(manualBuilder)
    val carManual = manualBuilder.getResult()
    println("\nCar manual built:")
    println(carManual.print())
}