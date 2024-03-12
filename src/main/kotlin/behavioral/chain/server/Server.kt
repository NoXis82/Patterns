package behavioral.chain.server

import behavioral.chain.middleware.Middleware


//Сервер, на который заходим
class Server() {

    private val users = hashMapOf<String, String>()
    private var middleware: Middleware? = null

    //     Клиент подаёт готовую цепочку в сервер. Это увеличивает гибкость и
//     упрощает тестирование класса сервера.
    fun setMiddleware(middleware: Middleware) {
        this.middleware = middleware
    }

    //      Сервер получает email и пароль от клиента и запускает проверку
//      авторизации у цепочки.
    fun logIn(email: String, password: String): Boolean {
        if (middleware!!.check(email, password)) {
            println("Authorization have been successful!")
            // Здесь должен быть какой-то полезный код, работающий для
            // авторизированных пользователей.
            return true
        }
        return false
    }

    fun register(email: String, password: String) {
        users[email] = password
    }

    fun hasEmail(email: String): Boolean {
        return users.containsKey(email)
    }

    fun isValidPassword(email: String, password: String): Boolean {
        return users[email] == password
    }
}