package behavioral.strategy.strategies

//Кредитная карта
class CreditCard(private val number: String, private val date: String, private val cvv: String) {
    private var amount: Int = 100_000

    fun setAmount(amount: Int) {
        this.amount = amount
    }

    fun getAmount(): Int {
        return this.amount
    }
}