package behavioral.strategy

import behavioral.strategy.order.Order
import behavioral.strategy.strategies.PayByCreditCard
import behavioral.strategy.strategies.PayByPayPal
import behavioral.strategy.strategies.PayStrategy
import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val priceOnProducts = hashMapOf<Int, Int>()
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val order = Order()
    var strategy: PayStrategy? = null

    priceOnProducts[1] = 2200
    priceOnProducts[2] = 1850
    priceOnProducts[3] = 1100
    priceOnProducts[4] = 890

    while (!order.isClosed()) {
        var cost: Int
        var continueChoice: String
        do {
            print(
                "Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n"
            )
            val choice = reader.readLine().toInt()
            cost = (priceOnProducts[choice])!!
            print("Count: ")
            val count = reader.readLine().toInt()
            order.setTotalCost(cost * count)
            print("Do you wish to continue selecting products? Y/N: ")
            continueChoice = reader.readLine()
        } while (continueChoice.equals("Y", ignoreCase = true))

        if (strategy == null) {
            println(
                ("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card")
            )
            val paymentMethod = reader.readLine()

            // Клиент создаёт различные стратегии на основании
            // пользовательских данных, конфигурации и прочих параметров.
            strategy = if ((paymentMethod == "1")) {
                PayByPayPal()
            } else {
                PayByCreditCard()
            }
        }

        // Объект заказа делегирует сбор платёжных данны стратегии, т.к.
        // только стратегии знают какие данные им нужны для приёма оплаты.
        order.processOrder(strategy)

        println("Pay ${order.getTotalCost()} units or Continue shopping? P/C: ")
        val proceed = reader.readLine()
        if (proceed.equals("P", ignoreCase = true)) {
            // И наконец, стратегия запускает приём платежа.
            if (strategy.pay(order.getTotalCost())) {
                println("Payment has been successful.")
            } else {
                println("FAIL! Please, check your data.")
            }
            order.setClosed()
        }
    }
}
//Результат выполнения
//Please, select a product:
//1 - Mother board
//2 - CPU
//3 - HDD
//4 - Memory
//1
//Count: 2
//Do you wish to continue selecting products? Y/N: y
//Please, select a product:
//1 - Mother board
//2 - CPU
//3 - HDD
//4 - Memory
//2
//Count: 1
//Do you wish to continue selecting products? Y/N: n
//Please, select a payment method:
//1 - PalPay
//2 - Credit Card
//1
//Enter the user's email: user@example.com
//Enter the password: qwerty
//Wrong email or password!
//Enter user email: amanda@ya.com
//Enter password: amanda1985
//Data verification has been successful.
//Pay 6250 units or Continue shopping?  P/C: p
//Paying 6250 using PayPal.
//Payment has been successful.