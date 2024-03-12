package behavioral.strategy.strategies

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

//Конкретная стратегия. Реализует оплату корзины интернет магазина через PayPal
class PayByPayPal() : PayStrategy {
    private var email: String? = null
    private var password: String? = null
    private var signedIn: Boolean = false

    init {
        DATA_BASE["amanda1985"] = "amanda@ya.com"
        DATA_BASE["qwerty"] = "john@amazon.eu"
    }


    //Собираем данные от клиента.
    override fun collectPaymentDetails() {
        try {
            while (!signedIn) {
                print("Enter the user's email: ")
                email = READER.readLine()
                print("Enter the password: ")
                password = READER.readLine()
                if (verify()) {
                    println("Data verification has been successful.")
                } else {
                    println("Wrong email or password!")
                }
            }
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    private fun verify(): Boolean {
        setSignedIn(email.equals(DATA_BASE[password]))
        return signedIn
    }

    //Если клиент уже вошел в систему, то для следующей оплаты данные вводить не придется
    override fun pay(paymentAmount: Int): Boolean {
        if (signedIn) {
            println("Paying $paymentAmount using PayPal.")
            return true
        } else {
            return false
        }
    }

    private fun setSignedIn(signedIn: Boolean) {
        this.signedIn = signedIn
    }

    companion object {
        private val DATA_BASE = hashMapOf<String, String>()
        private val READER = BufferedReader(InputStreamReader(System.`in`))
    }
}