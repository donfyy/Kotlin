package com.donfyy.kotlin

fun main() {
    //    println(describe()) 若方法未提供参数的默认值，则掉用处不可以省略对应的实参
//    Error:(28, 22) Kotlin: No value passed for parameter 'obj'
//    fun1()//编译报错：Error:(6, 10) Kotlin: No value passed for parameter 'a'

    fun2()//no problem，此处省略了一个实参

//    fun3(1)//编译错误：No value passed for parameter 'b'


    fun4()
    fun5()
    fun6()
}

private fun fun4() {
    listOf(1, 2, 3).forEach {
        if (it == 3) return //从最直接包围lambda表达式的函数返回
        // ⾮局部直接返回到 fun4() 的调⽤者
//        这种非局部的返回只支持传递给内联函数的lambda表达式
//        这不是坑人吗。。。卧槽
    }

    println("unreachable!")
}

private fun fun5() {
    listOf(1, 2, 3).forEach l@{
        if (it == 3) return@l // 从lambda表达式返回
    }

    println("fun5 reachable!")
}

private fun fun6() {
    listOf(1, 2, 3).forEach {
        if (it == 3) return@forEach // 从lambda表达式返回
    }

    println("fun6 reachable!")
}

fun fun1(a: Int) {

}

fun fun2(a: Int = 1) {

}

//第一个参数的默认值永远无法生效，调用者必须同时传入ab
fun fun3(a: Int = 0, b: Int) {

}

fun fun7() {
    var i = 1
    fun fun8(){
        i = 2
    }
    fun8()
    println(i)
}
