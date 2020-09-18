package classesandobjects

class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}
class Customer(val customerName: String = "")

open class Base(val name: String) {

    init { println("Initializing Base") }

    open val size: Int =
        name.length.also { println("Initializing size in Base: $it") }

    constructor(name: String, gender: String) : this(name) {
        println("Constructor body in Base")
    }
}

class Derived(
    name: String,
    val lastName: String
) : Base(name.capitalize().also { println("Argument for Base: $it") }, "M") {
    lateinit var v1: Derived
    init { println("Initializing Derived") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }

    constructor(name: String, lastName: String, gender: String) : this(name, lastName) {
        println("Constructor body in Derived")
    }
    fun f1() {

    }
}

fun main() {
    val d = Derived("Derived", "LastName", "M")
}