package com.donfyy.kotlin

import kotlin.math.absoluteValue

fun main(){
    val a : Int? = 1;
    val b : Long? = a?.toLong()
    if (b != null) {
        println(a.toLong() == b)
    }
}