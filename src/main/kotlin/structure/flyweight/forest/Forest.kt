package structure.flyweight.forest

import structure.flyweight.trees.Tree
import structure.flyweight.trees.TreeFactory
import structure.flyweight.trees.TreeType
import java.awt.Color
import java.awt.Graphics
import javax.swing.JFrame

//GUI-лес, который рисует деревья
class Forest : JFrame() {
    private val trees = arrayListOf<Tree>()

    fun plantTree(x: Int, y: Int, name: String, color: Color, otherTreeData: String) {
        val type: TreeType = TreeFactory.getTreeType(name, color, otherTreeData)
        val tree = Tree(x, y, type)
        trees.add(tree)
    }

    override fun paint(g: Graphics?) {
        for (tree in trees) {
            tree.draw(graphics)
        }
    }
}