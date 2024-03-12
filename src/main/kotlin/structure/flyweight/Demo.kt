package structure.flyweight

import structure.flyweight.forest.Forest
import java.awt.Color
import kotlin.math.floor


fun main() {
    val forest = Forest()
    for (i in 0 until floor((TREES_TO_DRAW / TREE_TYPES).toDouble()).toInt()) {
        forest.plantTree(
            random(0, CANVAS_SIZE),
            random(0, CANVAS_SIZE),
            "Summer Oak",
            Color.GREEN,
            "Oak texture stub"
        )
        forest.plantTree(
            random(0, CANVAS_SIZE),
            random(0, CANVAS_SIZE),
            "Autumn Oak",
            Color.ORANGE,
            "Autumn Oak texture stub"
        )
    }
    forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
    forest.isVisible = true;

    println("$TREES_TO_DRAW trees drawn")
    println("---------------------")
    println("Memory usage:")
    println("Tree size (8 bytes) * $TREES_TO_DRAW")
    println("+ TreeTypes size (~30 bytes) * $TREE_TYPES")
    println("---------------------")
    println("Total: ${((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024)}MB (instead of ${((TREES_TO_DRAW * 38) / 1024 / 1024)}MB)")
}

fun random(min: Int, max: Int): Int {
    return min + (Math.random() * ((max - min) + 1)).toInt()
}

const val CANVAS_SIZE: Int = 500
const val TREES_TO_DRAW: Int = 1000000
const val TREE_TYPES: Int = 2

//Статистика потребляемой памяти
//1000000 trees drawn
//---------------------
//Memory usage:
//Tree size (8 bytes) * 1000000
//+ TreeTypes size (~30 bytes) * 2
//---------------------
//Total: 7MB (instead of 36MB)