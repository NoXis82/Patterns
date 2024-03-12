package behavioral.strategy.strategies

//Общий интерфейс стратегий оплаты
interface PayStrategy {
    fun pay(paymentAmount: Int): Boolean
    fun collectPaymentDetails()
}