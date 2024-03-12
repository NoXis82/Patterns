package generating.prototype.shapes


//Базовый прототип
abstract class Shape {
    var x: Int = 0
    var y: Int = 0
    var color: String? = null

    // Обычный конструктор.
    constructor()

    // Конструктор прототипа.
    constructor(target: Shape?) : this() {
        target?.let {
            this.x = target.x
            this.y = target.y
            this.color = target.color
        }
    }

    // Результатом операции клонирования всегда будет объект из иерархии классов Shape.
    abstract fun clone(): Shape

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Shape) return false
        val shape2 = object2
        return shape2.x == x && shape2.y == y && shape2.color == color
    }
}