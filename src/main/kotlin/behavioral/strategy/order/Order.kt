package behavioral.strategy.order

import behavioral.strategy.strategies.PayStrategy

//Класс заказа. Ничего не знает о том каким способом (стратегией) будет
//расчитыватся клиент, а просто вызывает метод оплаты. Все остальное стратегия
//делает сама.
class Order() {
    private var totalCost = 0
    private var isClosed = false

    fun processOrder(strategy: PayStrategy) {
        strategy.collectPaymentDetails()
        // Здесь мы могли бы забрать и сохранить платежные данные из стратегии.
    }

    fun setTotalCost(cost: Int) {
        this.totalCost += cost
    }

    fun getTotalCost(): Int {
        return totalCost
    }

    fun isClosed(): Boolean {
        return isClosed
    }

    fun setClosed() {
        isClosed = true
    }
}