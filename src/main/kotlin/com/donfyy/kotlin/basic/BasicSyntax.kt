package com.donfyy.kotlin.basic


fun main() {
    variables()
    stringTemplates()
    conditionalExpressions()
    nullableValuesAndNullChecks()
    forLoop()
    whileLoop()
    whenExpression()
    ranges()
    collections()
}

//Functions
fun functions() {
    //Function having two Int parameters with Int return type
    fun sum1(a: Int, b: Int): Int {
        return a + b
    }

    //Function with an expression body and inferred return type
    fun sum2(a: Int, b: Int) = a + b

    //Function return no meaningful value
    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }
    //Unit return type can be omitted
    fun printSum2(a: Int, b: Int) {
        println("sum of $a and $b is ${a + b}")
    }
}

//Variables
private fun variables() {
    //Variables
    //readonly
    val a: Int = 1
    val b = 2
    val c: Int
    c = 1
    println("b:$b")
    //reassigned
    var x = 5
    x++
    println("x:$x")
}

//Top-level variables
val PI = 3.14
var x = 0

//String templates
fun stringTemplates() {
    var a = 1
    val s1 = "a is $a"
    println(s1)

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

//Conditional expressions
fun conditionalExpressions() {
    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun maxOf2(a: Int, b: Int) = if (a > b) a else b

    println("maxOf(1, 2) is ${maxOf(1, 2)}")
    println("maxOf2(1, 2) is ${maxOf2(1, 2)}")
}

//Nullable values and null checks
fun nullableValuesAndNullChecks() {
    fun parseInt(str: String): Int? {
        //Return null if str does not hold an integer
        return try {
            Integer.parseInt(str)
        } catch (e: Exception) {
            return null
        }
    }

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        if (x != null && y != null) {
            println("$x * $y is ${x * y}")
        } else {
            println("'$arg1' or '$arg2' is not a number")
        }
    }

    fun printProduct2(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        if (x == null) {
            println("Wrong number format in arg1: '$arg1'")
            return
        }
        if (y == null) {
            println("Wrong number format in arg2: '$arg2'")
            return
        }
        println("$x * $y is ${x * y}")
    }
    println("printProduct")
    printProduct("a", "1")
    printProduct("2", "1")
    println("printProduct2")
    printProduct2("a", "1")
    printProduct2("2", "1")
}

//Type checks and automatic casts
fun typeChecksAndAutomaticCasts() {
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            //`obj` is automatically cast to `String` in this branch
            return obj.length
        }
        //`obj` is still of type `Any` outside of the type-checked branch
        return null
    }

    fun getStringLength2(obj: Any): Int? {
        if (obj !is String) return null
        //`obj` is automatically cast to `String` in this branch
        return obj.length
    }

    fun getStringLength3(obj: Any): Int? {
        //`obj` is cast to `String` on the right-hand side of `&&`
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }
}

//for loop
fun forLoop() {
    println("for loop -----------------------------------")
    fun forLoop1() {
        val items = listOf("apple", "banana", "kiwifruit")
        for (item in items) {
            println(item)
        }
    }
    forLoop1()
    fun forLoop2() {
        val items = listOf("apple", "banana", "kiwifruit")
        for (i in items.indices) {
            println("item at $i is ${items[i]}")
        }
    }
    forLoop2()
}

// while loop
fun whileLoop() {
    println("while loop -----------------------------------")
    val items = listOf("apple", "banana", "kiwifruit")
    var i = 0
    while (i < items.size) {
        println("item at $i is ${items[i]}")
        i++
    }
}

//when expression
fun whenExpression() {
    println("when expression ------------------------------")
    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

    println(describe(1))
    println(describe("Hello"))
    println(describe(2L))
    println(describe(2.0))
    println(describe("xxx"))
}

//Ranges
fun ranges() {
    println("---------------Ranges --------------------------------------------")
    println("---------------Check if a number is within a range using in operator ------------")
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    println("---------------Check if a number is out of range ---------------")
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }
    println("---------------Iterating over a range ----------")
    for (x in 1..5) {
        print(x)
    }
    println()
    println("---------------Iterating over a progression -----------------")
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

//Collections
fun collections() {
    println("--------------Collections----------------------------------")
    println("--------------Iterating over a collection------------------")
    val items = listOf("apple", "banana", "kiwifruit", "orange")
    for (item in items) {
        println(item)
    }

    println("--------------Checking if a collection contains an object using in operator------------")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    println("-------------Using lambda expression to filter and map collections----------------------")
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits.filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.toUpperCase() }
        .forEach { println(it) }
}

//Creating basic classes and their instances
fun creatingBasicClassesAndTheirInstances() {
//    val rectangle = Rectangle(5.0, 2.0)
//    val triangle = Triangle(3.0, 4.0, 5.0)
}
