package generating.prototype.shapes

class Rectangle : Shape {

    var width: Int = 0
    var height: Int = 0

    constructor()

    constructor(target: Rectangle?) : super(target) {
        target?.let {
            this.width = it.width
            this.height = it.height
        }
    }

    override fun clone(): Shape {
        return Rectangle(this)
    }

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Rectangle || !super.equals(object2)) return false
        val shape2 = object2
        return shape2.width == width && shape2.height == height
    }
}