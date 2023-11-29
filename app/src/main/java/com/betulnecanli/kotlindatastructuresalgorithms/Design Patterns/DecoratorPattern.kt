// Component interface (the base coffee)
interface Coffee {
    fun cost(): Double
    fun description(): String
}

// Concrete component (the base coffee)
class SimpleCoffee : Coffee {
    override fun cost(): Double {
        return 2.0
    }

    override fun description(): String {
        return "Simple Coffee"
    }
}

// Decorator abstract class
abstract class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun cost(): Double {
        return decoratedCoffee.cost()
    }

    override fun description(): String {
        return decoratedCoffee.description()
    }
}

// Concrete decorator for adding milk
class MilkDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.5
    }

    override fun description(): String {
        return super.description() + ", Milk"
    }
}

// Concrete decorator for adding sugar
class SugarDecorator(decoratedCoffee: Coffee) : CoffeeDecorator(decoratedCoffee) {
    override fun cost(): Double {
        return super.cost() + 0.2
    }

    override fun description(): String {
        return super.description() + ", Sugar"
    }
}

fun main() {
    // Ordering a simple coffee
    val coffee: Coffee = SimpleCoffee()
    println("Cost: ${coffee.cost()}, Description: ${coffee.description()}")

    // Adding milk to the coffee
    val milkCoffee: Coffee = MilkDecorator(coffee)
    println("Cost: ${milkCoffee.cost()}, Description: ${milkCoffee.description()}")

    // Adding sugar to the coffee
    val sugarMilkCoffee: Coffee = SugarDecorator(milkCoffee)
    println("Cost: ${sugarMilkCoffee.cost()}, Description: ${sugarMilkCoffee.description()}")
}
