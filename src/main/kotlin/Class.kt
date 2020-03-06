package com.donfyy.kotlin

class Person constructor(val name: String) {
    val firstProperty: String = "first property".also(::println)

    init {
        println("init block 1.")
    }

    val secondProperty: String = "second property".also(::println)

    init {
        println("init block 2.")
    }

    constructor(name: String, isMale: Boolean, birth: String) : this(name) {
        println("secondary constructor")
    }

    init {
        println("init block 3. $name")
    }
}

open class Base(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size: Int = name.length.also { println("Initializing size in Base $it") }
}

class Derived(name: String, val lastName: String) : Base(name.capitalize().also { println("Argument for Base:$it") }) {
    init {
        println("Initialing Derived")
    }

    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived :$it") }
}

open class Rectangle {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val boarderColor: String get() = "black"
}

interface Polygon {
    fun draw() {}
}

//一个类从它的直接超类继承自相同成员的多个实现，它必须覆盖这个成员并提供自己的实现
class FilledRectangle : Rectangle(), IA, Polygon {
    override fun draw() {
        super<Rectangle>.draw()
//        draw方法必须重写,必须是相同成员有多个实现。
    }
//    override fun draw() {
//        super.draw()
//
//        println("Filling the rectangle")
//    }

    val fillColor: String get() = boarderColor
    override val a: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun fun1() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class C {
    private fun fun1() = object {
        val x: String = "x"
    }

    fun fun2() = object {
        val x: String = "x"
    }

    fun fun3() {
//        java 的方法会明确地指出返回值地类型，因此没有返回匿名对象的私有函数的返回类型是匿名对象类型一说
        var x = fun1().x
//        fun2().x
    }


}

object Singletona {
//  对象声明是在第一次被访问时延迟初始化的

    //    companion object Singletonb {
// 对象声明不能拥有伴生对象
//    }
    val value = B_CONST
}

const val B_CONST = 2

class Companion {
    val value = B_CONST

    companion object {
        const val A_CONST = 1
//        伴生对象是在对应类被加载时延迟初始化的
    }
}

//结构,接口本质上是方法的集合，不拥有状态。
//关系：一个接口可以继承自多个其他的接口，一个类可以实现多个接口
interface IA {
    val a: String//抽象的
    val b: String
        get() = "b"//或提供访问器的实现，不能有幕后字段

    fun fun1()
}

interface IB {
    fun fun1() {

    }
}
interface IC {
    fun fun1()
}

interface ID {
    fun fun1()
}

class CB : IB, IC {
    override fun fun1() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class CC : IB {

}

interface IID : IB, IC {
    override fun fun1()
}

interface IIC : IC, ID {}

class ClassIA : IA {
     override var a: String = ""
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {field = value}

    override val b: String
        get() = super.b

    override fun fun1() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun main() {
//    Person("donfyy", true, "20200101")

//    Derived("donfyy", "z")

    FilledRectangle().draw()
}