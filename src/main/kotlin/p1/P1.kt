package com.donfyy.kotlin.p1

import kotlin.reflect.jvm.internal.impl.renderer.KeywordStringsGenerated

const val B_CONST = 1
val constB = 1
    get() {
        return field
    }
val c = constB + B_CONST
    get() = field

lateinit var v3: String;

open class B {

}

//超类型列表里，最多只能有一个类，但可以有多个接口，和Java一致
class C : A() {

}

open class A {
    lateinit var v1: B
    private val v2: String = ""

    fun fun1() {
//        var initialized = v1.isInitialized
        var javaClass = v1?.javaClass
    }

    private fun fun2() {

    }
}

fun A.extFun1() {
//    this.v2   不能在类外部访问类的私有成员
}

//lateinit var v1 : Int; 不能用在基本类型变量上
//lateinit lateinit可用于顶层属性/属性/局部变量
//lateinit修饰的属性或变量不用判空，不知道什么时候会被初始化，初始化时间是在声明之后
//lateinit 不能用在有自定义getter或setter的属性上
//可以有全局变量，有点像c/c++
fun main() {
//    v3.is
//    com.donfyy.kotlin.B_CONST
//    顶层常量的作用域是全局的，常量全名要加上包名
}