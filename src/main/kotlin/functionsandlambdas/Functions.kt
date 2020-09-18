package functionsandlambdas

// 函数都是头等的，也就是说函数可以存储在变量和数据结构中，可以作为参数传递给函数也可以从函数返回
fun f(i: Int, convertor: (Int) -> String) {
    println(convertor(i))
}

fun main() {
    // 函数类型的三种实例
    // lambda表达式 （推荐）
    f(1) { i -> i.toString() }
    // 匿名函数
    f(2, fun(i: Int): String {
        return i.toString()
    })
    // 匿名对象
    f(3, object : (Int) -> String {
        override fun invoke(p1: Int): String {
            return p1.toString()
        }
    })
}