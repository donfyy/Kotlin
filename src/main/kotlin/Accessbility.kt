package com.donfyy.kotlin

open class B {
    private fun f1() {

    }

    private fun f2() {

    }
}
class Outer : B(){
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

fun Outer.f1() {
    f1()
}

fun Outer.f2() {
//    super.f2()
    this.f2()
}
//扩展函数与成员函数同名，若成员函数可被访问则优先使用成员函数。


fun main() {
    Outer().f1()
}