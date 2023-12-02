class Singleton private constructor() {
    init {
        println("Singleton instance created")
    }

    companion object {
        private val instance: Singleton by lazy { Singleton() }

        fun getInstance(): Singleton {
            return instance
        }
    }

    fun showMessage() {
        println("Hello, I am a singleton!")
    }
}

fun main() {
    // Trying to create multiple instances (won't work)
    val singleton1 = Singleton.getInstance()
    val singleton2 = Singleton.getInstance()

    println("Are they the same instance? ${singleton1 === singleton2}")

    // Accessing singleton method
    singleton1.showMessage()
}
