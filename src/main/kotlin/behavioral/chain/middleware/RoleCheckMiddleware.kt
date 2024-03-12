package behavioral.chain.middleware

//Проверка роли
//Конкретный элемент цепи обрабатывает запрос по-своему.
class RoleCheckMiddleware(): Middleware() {

    override fun check(email: String, password: String): Boolean {
        println(this.javaClass.name)
        if (email == "admin@example.com") {
            println("Hello, admin!")
            return true
        }
        println("Hello, user!")
        return checkNext(email, password)
    }
}