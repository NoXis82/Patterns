package structure.flyweight.trees

import java.awt.Graphics


//Объект, содержащий уникальное состояние дерева
class Tree(
    private val x: Int,
    private val y: Int,
    private val type: TreeType
) {

    fun draw(g: Graphics) {
        type.draw(g, x, y)
    }
}