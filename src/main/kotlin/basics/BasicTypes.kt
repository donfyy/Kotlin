package basics

/**
 * 在Kotlin中，所有的东西都是对象。
 * 数字，字符，布尔值可以在运行时表示为原生类型，但是对用户来说，它们看起来就像普通的类。
 */
fun main() {
    numbers2()
    numbers4()
    numbers5()
    numbers6()
    numbers11()
    string1()
    string3()
    string4()
}

// 数字
// 未超出Int最大值的整数初始化的变量会被推断为Int，如果变量初始值超出Int最大值，
// 那么变量会被推断为Long类型
fun numbers1() {
    val one = 1 // Int
    val threeBillion = 3000000000 // Long
    val oneLong = 1L // Long
    val oneByte: Byte = 1 // Byte
}

// Kotlin 提供了 Float 与 Double 来表示浮点数。
// 以小数初始化的变量会被推断为 Double
fun numbers2() {
    val pi = 3.14 // Double
    val e = 2.718281828412345678 // Double 实际值为 2.7182818284123456
    val eFloat = 2.7182818284f // Float，实际值为 2.7182817
    println(e)
    println(eFloat)
}

// Kotlin中的数字没有隐式拓宽转换。
fun numbers3() {
    fun printDouble(d: Double) {
        println(d)
    }

    val i = 1
    val d = 1.1
    val f = 1.1f
    printDouble(d)
//    printDouble(i) // 错误：类型不匹配
//    printDouble(f) // 错误：类型不匹配
}

// 字面常量
// 十进制：123 十六进制：0x0F 二进制：0b00001011
// 不支持八进制
// double：123.5 123.5e10
// float：123.5f 123.5F
fun numbers4() {
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    val float = 123.5f
    val double = 123.5e1 // 1235.0
}

// 表示方式
// 在 Java 平台数字是物理存储为 JVM 的原生类型，除非我们需要一个可空的引用（如 Int?）或泛型。 后者情况下会把数字装箱。
fun numbers5() {
    val a: Int = -128
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 128
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    // 注意数字装箱不一定保留同一性
    println(boxedA === anotherBoxedA) // true  -128 <= a <= 127
    println(boxedB === anotherBoxedB) // false
}

fun numbers6() {
    val a: Int = 10000
    println(a == a) // 输出“true”
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    // 注意数字装箱保留相等性
    println(boxedA == anotherBoxedA) // 输出“true”
}

// 显式转换
// 由于不同的表示方式，较小类型并不是较大类型的子类型。如果它们是的话，就会出现下述问题
fun numbers7() {
    // 假想的代码，实际上并不能编译：
//    val a: Int? = 1 // 一个装箱的 Int (java.lang.Integer)
//    val b: Long? = a // 隐式转换产生一个装箱的 Long (java.lang.Long)
//    print(b == a) // 惊！这将输出“false”鉴于 Long 的 equals() 会检测另一个是否也为 Long
}

/**
 * 所以相等性会在所有地方悄无声息地失去，更别说同一性了。
 * 因此较小的类型不能隐式转换为较大的类型。
 * 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。
 * 缺乏隐式类型转换很少会引起注意，因为类型会从上下文推断出来，而算术运算会有重载做适当转换，例如：
 */
fun numbers8() {
    val l = 1L + 3 // Long + Int => Long
    // public operator fun plus(other: Int): Long
}

/**
 * 运算
 * Kotlin支持数字运算的标准集（+ - * / %），运算被定义为相应的类成员（但编译器会将函数调用优化为相应的指令）。
 * 参见运算符重载。
 *
 * 整数除法
 * 请注意，整数间的除法总是返回整数。
 * 如需返回浮点类型，请将其中的一个参数显式转换为浮点类型。
 */
fun numbers9() {
    val x = 5 / 2.toDouble()
    println(x == 2.5)
}

/**
 * 位运算
 *
 * 对于位运算，没有特殊字符来表示，而只可用中缀方式调用具名函数，例如:
 */
fun numbers10() {
    val x = (1 shl 2) and 0x000FF000.inv()
}

/**
 * 浮点数比较
 *
 * 为了支持泛型场景并提供全序支持，当这些操作数并非静态类型并为浮点数（例如是 Any、 Comparable<……>、 类型参数）时，
 * 这些操作使用为 Float 与 Double 实现的不符合标准的 equals 与 compareTo，这会出现：
 * - 认为 NaN 与其自身相等
 * - 认为 NaN 比包括正无穷大（POSITIVE_INFINITY）在内的任何其他元素都大
 * - 认为 -0.0 小于 0.0
 */
fun numbers11() {
    println("11----------------------------")
    println(Float.NaN == Float.NaN) // false
    println(Float.NaN === Float.NaN) // false
    println(Float.NaN.equals(Float.NaN)) // true
    println(Float.NaN.compareTo(Float.NaN)) // 0
    println(Float.NaN > Float.POSITIVE_INFINITY) // false
    println(Float.NaN.compareTo(Float.POSITIVE_INFINITY)) // 1
    println(-0.0f == 0.0f) // true
    println((-0.0f).equals(0.0f)) // false
    println((-0.0f).compareTo(0.0f)) // -1
}

/**
 * 字符
 * 字符用 Char 类型表示。它们不能直接当作数字
 */
fun check(c: Char) {
//    if (c == 1) { // 错误：类型不兼容
    // ……
//    }
}

/**
 * 字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。
 * 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 与 \$。 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。
 *
 * 当需要可空引用时，像数字、字符会被装箱。装箱操作不会保留同一性。
 * 我们可以显式把字符转换为 Int 数字：
 */
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}

/**
 * Kotlin 中数组是不型变的（invariant）。
 * 这意味着 Kotlin 不让我们把 Array<String> 赋值给 Array<Any>，
 * 以防止可能的运行时失败（但是你可以使用 Array<out Any>, 参见类型投影）。
 */
fun array1() {
    val arrayString: Array<String?> = arrayOfNulls(5)
    var arrayAny: Array<Any?>? = null
//    arrayAny = arrayString // 编译错误
//    java 可以
//        String[] b = null;
//        Object[] a = b;
}

/**
 * 无符号整型
 */
fun unsignedIntegers1() {
    val b: UByte = 1u  // UByte，已提供预期类型
    val s: UShort = 1u // UShort，已提供预期类型
    val l: ULong = 1u  // ULong，已提供预期类型

    val a1 = 42u // UInt：未提供预期类型，常量适于 UInt
    val a2 = 0xFFFF_FFFF_FFFFu // ULong：未提供预期类型，常量不适于 UInt
}

/**
 * 字符串
 * 字符串用 String 类型表示。字符串是不可变的。
 * 字符串的元素——字符可以使用索引运算符访问: s[i]。 可以用 for 循环迭代字符串:
 */
fun string1() {
    val str = "abc"
    for (c in str) {
        println(c)
    }
}

/**
 * 字符串字面值
 * Kotlin 有两种类型的字符串字面值: 转义字符串可以有转义字符， 以及原始字符串可以包含换行以及任意文本。
 */
fun string2() {
    val s = "Hello, world!\n" // 转义字符串
    val text = """
    for (c in "foo")
        print(c)
""" // 原始字符串
}

/**
 * 可以通过 trimMargin() 函数去除前导空格
 * 默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
 */
fun string3() {
    val text = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)
}

/**
 * 字符串字面值可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。
 * 模板表达式以美元符（$）开头，由一个简单的名字构成:
 */
fun string4() {
    val i = 10
    println("i = $i") // 输出“i = 10”

    // 或者用花括号括起来的任意表达式:
    val s = "abc"
    println("$s.length is ${s.length}") // 输出“abc.length is 3”

    // 原始字符串与转义字符串内部都支持模板。
    // 如果你需要在原始字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
    val price = """
                |${'$'}9.99
                """.trimMargin()
    println(price)
}