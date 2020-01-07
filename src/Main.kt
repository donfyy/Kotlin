package com.donfyy.kotlin

fun main() {
    println("hi my first kotlin main!")
    println("z went away, the past has passed. let's do something interesting and valuable")
    val i = 1
    val j = 2
    println("sum of i and j:" + (i  + j))
    println("sum of i and j using function:" + sum(i, j))
//    字符串模板模版模样
    println("max of $i and $j is :" + maxOf(i, j))
    println("max of '$i' and '$j' is :" + maxOf(i, j))

    nullCheck()

    iterator()

    whileIterate()

    println(describe(1))
    println(describe("hello"))
    println(describe("hello1111"))
    println(describe(null))
    println(describe(3))


//    was range appeared in my past career?
    println("is 1 in range [1, 2] ${isInRange(1, 1, 2)}")
    println("is 1 in range [3, 5] ${isInRange(1, 3, 5)}")
    println("is 1 in range [2, 1] ${isInRange(1, 2, 1)}")

}


fun isInRange(target:Int, min:Int, max:Int) = target in min..max


//when表达式
fun describe(obj: Any?):String =
    when (obj) {
        //a replacement and enhancement for keyword switch and if ? not switch ,
        //just a convenient approach for endless "if else".
        1 -> {
            "one"
        }
        2 -> "two"
        "hello" -> "greeting"
        !is String -> "not a string"
        else -> {
            "unknown"
        }
    }

private fun whileIterate() {
    val items = listOf("apple", "banana", "kiwifruit", "guava")
    var index = 0
    while ((index < items.size)) {
        println("item at $index is ${items[index]}")
        index++
    }
}

//for循环
private fun iterator() {
    run{
        val items = listOf("apple", "banana", "kiwifruit", "guava")
        for (item in items) {
            println(item)
        }
    }

    run{
        val items = listOf("apple", "banana", "kiwifruit", "guava")
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }
    }

    run{
//        用lambda对集合迭代
        val items = listOf("apple", "banana", "kiwifruit", "guava")
        items.filter { it.startsWith("g") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it)}
    }
}

private fun nullCheck() {
    //    空值与null检测
    var k: Int? = 1
//    println(k + j)
//    Error:(16, 15) Kotlin: Operator call corresponds to a dot-qualified call 'k.plus(j)' which is not allowed on a nullable receiver 'k'.

    k = null
    println("is null a Int?: ${k is Int}")
}

fun sum(i: Int, j: Int) = i + j

//条件表达式
fun maxOf(i: Int, j: Int) = if (i > j) i else j
//类型检测与自动类型转换
fun getStringLength(o : Any): Int? {
    if (o is String) {
        return o.length
    }

    return null
}

