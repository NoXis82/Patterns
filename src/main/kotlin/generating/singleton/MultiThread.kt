package generating.singleton

fun main() {
    println("If you see the same value, then singleton was reused (yay!)")
    println("If you see different values, then 2 singletons were created (booo!!)")
    println("RESULT:")
    val threadFoo =  Thread(ThreadFoo())
    val threadBar = Thread(ThreadBar())
    threadFoo.start()
    threadBar.start()
}

internal class ThreadFoo : Runnable {
    override fun run() {
        val singleton = SingletonMultiThread.getInstance("FOO")
        println(singleton?.value)
    }
}

internal class ThreadBar : Runnable {
    override fun run() {
        val singleton = SingletonMultiThread.getInstance("BAR")
        println(singleton?.value)
    }
}

//Результаты выполнения
//If you see the same value, then singleton was reused (yay!)
//If you see different values, then 2 singletons were created (booo!!)
//RESULT:
//FOO
//BAR