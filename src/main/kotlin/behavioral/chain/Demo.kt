package behavioral.chain

import behavioral.chain.middleware.RoleCheckMiddleware
import behavioral.chain.middleware.ThrottlingMiddleware
import behavioral.chain.middleware.UserExistsMiddleware
import behavioral.chain.server.Server
import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val server = Server()
    server.register("admin@example.com", "admin_pass")
    server.register("user@example.com", "user_pass")
    // Проверки связаны в одну цепь. Клиент может строить различные цепи,
    // используя одни и те же компоненты.
    val middleware = ThrottlingMiddleware(2)
    middleware.linkWith(UserExistsMiddleware(server)).linkWith(RoleCheckMiddleware())
    // Сервер получает цепочку от клиентского кода.
    server.setMiddleware(middleware)

    var success: Boolean
    do {
        println("Enter email: ")
        val email = reader.readLine()
        println("Input password: ")
        val password = reader.readLine()
        success = server.logIn(email, password)
    } while (!success)

}
//Результат выполнения
//Enter email: admin@example.com
//Input password: admin_pass
//Hello, admin!
//Authorization have been successful!

//Enter email: user@example.com
//Input password: user_pass
//Hello, user!
//Authorization have been successful!