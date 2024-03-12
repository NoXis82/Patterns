package structure.flyweight.trees

import java.awt.Color

//Фабрика деревьев
class TreeFactory {

    companion object {
        private val treeTypes = hashMapOf<String, TreeType>()

        fun getTreeType(name: String, color: Color, otherTreeData: String): TreeType {
            var result = treeTypes[name]
            if (result == null) {
                result = TreeType(name, color, otherTreeData)
                treeTypes[name] = result
            }
            return result
        }
    }
}