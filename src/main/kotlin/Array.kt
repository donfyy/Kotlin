package com.donfyy.kotlin

import com.donfyy.kotlin.p1.A
import com.donfyy.kotlin.p1.c
import com.donfyy.kotlin.p1.v3

//const val B_CONST= 1

fun main() {
    val array: Array<Int> = arrayOf(1, 2);
    println(array[0])
//    A().v1.is
    val arr = Array(2) { IntArray(3) }
    for (one in arr)
        for (two in one) {
            println(two)
        }
}