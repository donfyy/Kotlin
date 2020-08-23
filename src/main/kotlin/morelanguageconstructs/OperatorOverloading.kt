package morelanguageconstructs

data class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)

/**
 * 1.编译器首先确定point的类型T
 * 2.为接收者T查找一个带有operator修饰符的无参构造函数unaryMinus()，成员函数或者扩展函数。
 * 3.如果函数不存在或不明确，跳转到5
 * 4.假设返回类型为R，则表达式-point返回R的实例
 * 5.编译错误
 */
fun operatorOverride1() {
    println(-point)  // 输出“Point(x=-10, y=-20)”
}

fun main() {
    operatorOverride1()
}