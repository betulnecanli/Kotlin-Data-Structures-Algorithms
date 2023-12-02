class Person {
    var name: String = ""
    var age: Int = 0
    var address: String = ""

    fun setName(name: String): Person {
        this.name = name
        return this
    }

    fun setAge(age: Int): Person {
        this.age = age
        return this
    }

    fun setAddress(address: String): Person {
        this.address = address
        return this
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age, address='$address')"
    }
}

fun main() {
    // Using Fluent Interface to create a Person object
    val person = Person()
        .setName("John")
        .setAge(25)
        .setAddress("123 Main St")

    println(person)
}
