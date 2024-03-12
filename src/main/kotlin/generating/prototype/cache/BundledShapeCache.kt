package generating.prototype.cache

import generating.prototype.shapes.Circle
import generating.prototype.shapes.Rectangle
import generating.prototype.shapes.Shape

//Фабрика прототипов
class BundledShapeCache() {
    private val cache = HashMap<String, Shape>()

    init {
        val circle = Circle()
        circle.x = 5
        circle.y = 7
        circle.radius = 45
        circle.color = "Green"

        val rectangle = Rectangle()
        rectangle.x = 6
        rectangle.y = 9
        rectangle.width = 8
        rectangle.height = 10
        rectangle.color = "Blue"

        cache["Big green circle"] = circle
        cache["Medium blue rectangle"] = rectangle
    }

    fun put(key: String, shape: Shape): Shape {
        cache[key] = shape
        return shape
    }

    fun get(key: String): Shape? {
        return cache[key]?.clone()
    }
}