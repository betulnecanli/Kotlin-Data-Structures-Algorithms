// Product class (the object to be constructed)
data class Person(
    val name: String?,
    val age: Int?,
    val address: String?,
    val phoneNumber: String?
)

// Builder interface
interface PersonBuilder {
    fun setName(name: String): PersonBuilder
    fun setAge(age: Int): PersonBuilder
    fun setAddress(address: String): PersonBuilder
    fun setPhoneNumber(phoneNumber: String): PersonBuilder
    fun build(): Person
}

// Concrete builder implementing the PersonBuilder interface
class ConcretePersonBuilder : PersonBuilder {
    private var name: String? = null
    private var age: Int? = null
    private var address: String? = null
    private var phoneNumber: String? = null

    override fun setName(name: String): PersonBuilder {
        this.name = name
        return this
    }

    override fun setAge(age: Int): PersonBuilder {
        this.age = age
        return this
    }

    override fun setAddress(address: String): PersonBuilder {
        this.address = address
        return this
    }

    override fun setPhoneNumber(phoneNumber: String): PersonBuilder {
        this.phoneNumber = phoneNumber
        return this
    }

    override fun build(): Person {
        return Person(name, age, address, phoneNumber)
    }
}

// Client code using the builder to construct a Person object
fun main() {
    val personBuilder = ConcretePersonBuilder()

    val person1 = personBuilder.setName("John").setAge(30).build()
    val person2 = personBuilder.setName("Alice").setAddress("123 Main St").setPhoneNumber("555-1234").build()

    println(person1)
    println(person2)
}
