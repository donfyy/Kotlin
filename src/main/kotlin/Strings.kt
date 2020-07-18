package com.donfyy.kotlin

fun main() {
    val text = """ 
    |Tell me and I forget. 
    |Teach me and I remember. 
    |Involve me and I learn. 
    |(Benjamin Franklin) """.trimMargin()
    println(text)
    /*Tell me and I forget.
Teach me and I remember.
Involve me and I learn.
(Benjamin Franklin) */
    for (c in text) {
        println(c)
    }
    println(text[1])
}