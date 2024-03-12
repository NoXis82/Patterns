package generating.singleton

class Singleton private constructor(value: String) {

    var value: String
    init {
        // Этот код эмулирует медленную инициализацию.
        try {
            Thread.sleep(1000)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
        this.value = value
    }

    companion object {
        private var instance: Singleton? = null
        fun getInstance(value: String): Singleton? {
            if (instance == null) {
                instance = Singleton(value)
            }
            return instance
        }
    }
}