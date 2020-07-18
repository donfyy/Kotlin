package main.kotlin.com.donfyy.kotlin.`fun`

fun <T, R> Collection<T>.fold(initial: R, combine: (R, T) -> R): R {
    var accumulator = initial
    for (e in this) {
        accumulator = combine(accumulator, e)
    }
    return accumulator
}

fun main() {
    val items = listOf(1, 2, 3)
    println(items.fold(0, { a, b -> a + b }))
    println(items.fold(0, fun(a, b) = a + b))
    println(items.fold(0, object : (Int, Int) -> Int {
        override fun invoke(p1: Int, p2: Int): Int {
            return p1 + p2
        }
    }))
    println(items.fold(0, ::combine))
}

fun combine(a: Int, b: Int) = a + b