package generating.prototype.shapes

// Конкретный прототип. Метод клонирования создаёт новый объект
// текущего класса, передавая в его конструктор ссылку на
// собственный объект. Благодаря этому операция клонирования
// получается атомарной — пока не выполнится конструктор, нового
// объекта ещё не существует. Но как только конструктор завершит
// работу, мы получим полностью готовый объект-клон, а не пустой
// объект, который нужно ещё заполнить.
class Circle : Shape {
    var radius: Int = 0

    constructor()

    // Вызов родительского конструктора нужен, чтобы скопировать потенциальные приватные поля, объявленные
    // в родительском классе.
    constructor(target: Circle?) : super(target) {
        target?.let {
            this.radius = it.radius
        }
    }

    override fun clone(): Shape {
        return Circle(this)
    }

    override fun equals(object2: Any?): Boolean {
        if (object2 !is Circle || !super.equals(object2)) return false
        return object2.radius == radius
    }
}