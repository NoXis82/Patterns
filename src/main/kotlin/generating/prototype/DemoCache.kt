package generating.prototype

import generating.prototype.cache.BundledShapeCache

fun main() {
    val cache = BundledShapeCache()

    val shape1 = cache.get("Big green circle")
    val shape2 = cache.get("Medium blue rectangle")
    val shape3 = cache.get("Medium blue rectangle")

    if (shape1 !== shape2 && !shape1!!.equals(shape2)) {
        println("Big green circle != Medium blue rectangle (yay!)")
    } else {
        println("Big green circle == Medium blue rectangle (booo!)")
    }

    if (shape2 !== shape3) {
        println("Medium blue rectangles are two different objects (yay!)")
        if (shape2!!.equals(shape3)) {
            println("And they are identical (yay!)")
        } else {
            println("But they are not identical (booo!)")
        }
    } else {
        println("Rectangle objects are the same (booo!)")
    }
}