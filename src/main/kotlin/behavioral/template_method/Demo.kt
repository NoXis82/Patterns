package behavioral.template_method

import behavioral.template_method.networks.Facebook
import behavioral.template_method.networks.Network
import behavioral.template_method.networks.Twitter
import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var network: Network? = null
    print("Input user name: ")
    val userName = reader.readLine()
    print("Input password: ")
    val password = reader.readLine()

    // Вводим сообщение.
    print("Input message: ")
    val message = reader.readLine()
    println(
        """
            Choose social network for posting message.
            1 - Facebook
            2 - Twitter
            """.trimIndent()
    )
    val choice = reader.readLine().toInt()

    // Создаем сетевые объекты и публикуем пост.
    if (choice == 1) {
        network = Facebook(userName, password)
    } else if (choice == 2) {
        network = Twitter(userName, password)
    }
    network!!.post(message)
}

//Результат выполнения
//Input user name: Jhonatan
//Input password: qswe
//Input message: Hello, World!

//Choose social network for posting message.
//1 - Facebook
//2 - Twitter
//2

//Checking user's parameters
//Name: Jhonatan
//Password: ****
//..........

//LogIn success on Twitter
//Message: 'Hello, World!' was posted on Twitter
//User: 'Jhonatan' was logged out from Twitter