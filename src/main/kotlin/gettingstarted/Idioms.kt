package gettingstarted

import com.google.gson.Gson
import com.google.gson.JsonElement
import java.math.BigDecimal
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
}

//Builder-style usage of methods that return unit
fun arrayOfMinusOnes(size: Int) = IntArray(size).apply { fill(-1) }

//Calling multiple methods on an object instance (with)
class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(degree: Double) {}
    fun forward(pixels: Double) {}
}

fun callingMultipleMethodsOnAnObjectInstanceWith() {
    val turtle = Turtle()
    with(turtle) {
        penDown()
        for (i in 1..4) {
            forward(100.0)
            turn(90.0)
        }
        penUp()
    }
}

//Configuring properties of an object (apply)
fun configuringPropertiesOfAnObject() {
//    val myRectangle = Rectangle().apply {
//        length = 4
//        breadth = 5
//        color = 0xFAFAFA
//    }
}

//Java 7's try with resources
fun java7sTryWithResources() {
    val stream = Files.newInputStream(Paths.get("/"))
    stream.buffered().reader().use {
        println(it.readText())
    }
}

//Convenient form for a generic function that requires the generic type information
// public final class Gson {
//      ...
//      public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
//      ...
inline fun <reified T : Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)

//Consuming a nullable Boolean
fun consumingANullableBoolean() {
    val b: Boolean? = null
    if (b == true) {
//        ...
    } else {
        // `b` is false or null
    }
}

//Swapping two variables
fun swappingTwoVariable() {
    var a = 1
    var b = 2
    a = b.also { b = a }
//    Python: a, b = b, a
}

//TODO():Marking code as incomplete
fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")