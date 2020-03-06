package com.donfyy.kotlin

class Outer {
    class Inter {
        var p1: String = ""
    }

    inner class Inner {
        var p1: String = ""
    }

    fun f1() {
        var p1 = Inter().p1

        var p11 = Inner().p1
    }
}