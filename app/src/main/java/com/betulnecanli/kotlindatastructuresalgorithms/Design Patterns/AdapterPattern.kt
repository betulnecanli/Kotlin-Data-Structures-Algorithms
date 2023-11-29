// Target interface expected by the client
interface Target {
    fun request(): String
}

// Adaptee (legacy class) with a different interface
class Adaptee {
    fun specificRequest(): String {
        return "Adaptee's specific request"
    }
}

// Adapter class implementing the Target interface and delegating to the Adaptee
class Adapter(private val adaptee: Adaptee) : Target {
    override fun request(): String {
        // Convert the Adaptee's specific interface to the Target interface
        return "Adapter: ${adaptee.specificRequest()}"
    }
}

// Client code that expects to work with the Target interface
fun clientCode(target: Target) {
    println(target.request())
}

fun main() {
    val adaptee = Adaptee()
    val adapter = Adapter(adaptee)

    // The client code can work with the Target interface through the Adapter
    clientCode(adapter)
}
