package generating.singleton

fun main() {
    println("If you see the same value, then singleton was reused (yay!)")
    println("If you see different values, then 2 singletons were created (booo!!)")
    println("RESULT:")
    val singleton = Singleton.getInstance("FOO")
    val anotherSingleton = Singleton.getInstance("BAR")
    println(singleton?.value)
    println(anotherSingleton?.value)
}

//Результат выполнения
//If you see the same value, then singleton was reused (yay!)
//If you see different values, then 2 singletons were created (booo!!)
//RESULT:
//FOO
//FOO