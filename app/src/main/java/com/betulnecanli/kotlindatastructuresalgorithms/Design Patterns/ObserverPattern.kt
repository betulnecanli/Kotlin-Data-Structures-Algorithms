// Observer interface
interface Observer {
    fun update(newState: String)
}

// Concrete observer
class ConcreteObserver(private val name: String) : Observer {
    override fun update(newState: String) {
        println("$name received an update: $newState")
    }
}

// Subject interface
interface Subject {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

// Concrete subject
class ConcreteSubject : Subject {
    private val observers = mutableListOf<Observer>()
    private var state: String = ""

    fun setState(newState: String) {
        state = newState
        notifyObservers()
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(state)
        }
    }
}

fun main() {
    // Create subject and observers
    val subject = ConcreteSubject()
    val observer1 = ConcreteObserver("Observer 1")
    val observer2 = ConcreteObserver("Observer 2")

    // Add observers to the subject
    subject.addObserver(observer1)
    subject.addObserver(observer2)

    // Change state of the subject and notify observers
    subject.setState("New State 1")

    // Remove one observer and notify again
    subject.removeObserver(observer1)
    subject.setState("New State 2")
}
