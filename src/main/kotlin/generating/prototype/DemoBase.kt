package generating.prototype

import generating.prototype.shapes.Circle
import generating.prototype.shapes.Rectangle
import generating.prototype.shapes.Shape

fun main() {
    val shapes = arrayListOf<Shape>()
    val shapesCopy = arrayListOf<Shape>()

    val circle = Circle()
    circle.x = 10
    circle.y = 20
    circle.radius = 15
    circle.color = "red"
    shapes.add(circle)
    val anotherCircle = circle.clone()
    shapes.add(anotherCircle)

    val rectangle = Rectangle()
    rectangle.height = 20
    rectangle.width = 10
    rectangle.color = "blue"
    shapes.add(rectangle)
    shapes.forEach { shapesCopy.add(it.clone()) }
    cloneAndCompare(shapes, shapesCopy)
}

private fun cloneAndCompare(shapes: List<Shape>, shapesClone: List<Shape>) {
    for ((index, value) in shapes.withIndex()) {
        if (shapes[index] !== shapesClone[index]) {
            println("$index: Shapes are different objects (yay!)")
            if (shapes[index].equals(shapesClone[index])) {
                println("$index: And they are identical (yay!)")
            } else {
                println("$index: But they are not identical (booo!)")
            }
        } else {
            println("$index: Shape objects are the same (booo!)")
        }
    }
}