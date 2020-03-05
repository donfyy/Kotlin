package com.donfyy.kotlin.p1

const val B_CONST = 1
val constB = 1
get() {
    return field
}
val c = constB + B_CONST
get() = field

lateinit var v3 : String;
//lateinit lateinit可用于顶层属性/属性/局部变量
//lateinit修饰的属性或变量不用判空，不知道什么时候会被初始化，初始化时间是在声明之后
//可以有全局变量，有点像c/c++
fun main() {
//    com.donfyy.kotlin.B_CONST
//    顶层常量的作用域是全局的，常量全名要加上包名
}