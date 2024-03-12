package generating.singleton

class SingletonMultiThread private constructor(value: String) {

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
        // Поле обязательно должно быть объявлено volatile, чтобы двойная проверка блокировки сработала как надо.
        @Volatile
        private var instance: SingletonMultiThread? = null

        // Техника, которую мы здесь применяем называется «блокировка с двойной
        // проверкой» (Double-Checked Locking). Она применяется, чтобы
        // предотвратить создание нескольких объектов-одиночек, если метод будет
        // вызван из нескольких потоков одновременно.
        //
        // Хотя переменная `result` вполне оправданно кажется здесь лишней, она
        // помогает избежать подводных камней реализации DCL в Java.
        fun getInstance(value: String): SingletonMultiThread? {

            val result = instance
            if (result != null) {
                return result
            }
            
            synchronized(SingletonMultiThread::class.java) {
                if (instance == null) {
                    instance = SingletonMultiThread(value)
                }
                return instance
            }
        }
    }
}