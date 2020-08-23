package classesandobjects

/**
 * 类、对象、接口、构造函数、方法、属性和它们的 setter 都可以有 可见性修饰符。
 * （getter 总是与属性有着相同的可见性。）
 * 在 Kotlin 中有这四个可见性修饰符：private、 protected、 internal 和 public。
 * 如果没有显式指定修饰符的话，默认可见性是 public。
 * 这些修饰符如何应用到不同类型的声明作用域？
 *
 * 包
 *
 * 函数、属性和类、对象和接口可以在顶层声明，即直接在包内
 * 1.如果你不指定任何可见性修饰符，默认为 public，这意味着你的声明将随处可见
 * 2.如果你声明为 private，它只会在声明它的文件内可见
 * 3.如果你声明为 internal，它会在相同模块内随处可见
 * 4.protected 不适用于顶层声明。
 */

private fun foo() {} // 在 example.kt 内可见
public var bar: Int = 5 // 该属性随处可见
    private set         // setter 只在 example.kt 内可见
internal val baz = 6    // 相同模块内可见
//protected class Class2 // protected不能用在file中

/**
 * 类和接口
 * 对于类内部声明的成员：
 * 1.private意味着只在这个类内部（包含其所有成员）可见
 * 2.protected意味着在类内部（包含其所有成员）以及子类中可见
 * 3.internal意味着能见到类声明的本模块内的客户端可见
 * 4.public意味着能见到类声明的任何客户端都可见
 *
 * 在Kotlin中外部类不能访问内部类的private成员。
 * 如果子类覆盖了protected成员但是没有显式指定其可见性，则子类成员的可见性依然是protected
 */

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4  // 默认 public

    protected class Nested {
        public val e: Int = 5
    }
    private companion object {}
}

class Subclass : Outer() {
    // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见

    override val b = 5   // “b”为 protected
}

class Unrelated(o: Outer) {
    // o.a、o.b 不可见
    // o.c 和 o.d 可见（相同模块）
    // Outer.Nested 不可见，Nested::e 也不可见
}

/**
 * 构造函数
 * 要指定一个类的的主构造函数的可见性，使用以下语法（注意你需要添加一个显式 constructor 关键字）
 * 局部声明
 * 局部变量、函数和类不能有可见性修饰符。
 *
 * 模块
 * 可见性修饰符 internal 意味着该成员只在相同模块内可见。更具体地说， 一个模块是编译在一起的一套 Kotlin 文件
 * 1.一个 IntelliJ IDEA 模块
 * 2.一个 Maven 项目
 * 3.一个 Gradle 源集（例外是 test 源集可以访问 main 的 internal 声明）
 * 4.一次 <kotlinc> Ant 任务执行所编译的一套文件
 */
class C private constructor(a: Int) {  }
fun main() {
    class abc {}
    abc()
}