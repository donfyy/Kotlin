package main.kotlin.com.donfyy.kotlin.idioms

import java.util.*


fun swapping() {
    var a = 1
    var b = 2
    a = b.also { b = a }
    println("a:$a, b:$b")
}

fun main() {
    val array = intArrayOf(5, 3, 2, 1)
    bubbleSort(array)
    println(Arrays.toString(array))
}

fun bubbleSort(array: IntArray) {
    for (i in array.size - 1 downTo 1) {
        for (j in 0 until i) {
            if (array[j] > array[j + 1])
                array[j] = array[j + 1].also { array[j + 1] = array[j] }
        }
    }
}