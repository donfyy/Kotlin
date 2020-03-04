package com.donfyy.kotlin

class Person constructor(val name: String) {
    val firstProperty: String = "first property".also(::println)

    init {
        println("init block 1.")
    }

    val secondProperty: String = "second property".also(::println)

    init {
        println("init block 2.")
    }

    constructor(name: String, isMale: Boolean, birth: String) : this(name) {
        println("secondary constructor")
    }

    init {
        println("init block 3. $name")
    }
}


fun main() {
    Person("donfyy", true, "20200101")
}