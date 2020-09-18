
- 所有东西都是对象。
- 函数都是头等的
- 数字，没有隐式类型拓宽转换。必须使用显式转换来拓宽数字。
- 数字的运算符被定义为相应的类成员，但编译器会将函数调用优化为相应的指令。
- 注意下浮点数的比较

```kotlin
    println(Float.NaN == Float.NaN) // false
    println(Float.NaN === Float.NaN) // false
    println(Float.NaN.equals(Float.NaN)) // true
    println(Float.NaN.compareTo(Float.NaN)) // 0
    println(Float.NaN > Float.POSITIVE_INFINITY) // false
    println(Float.NaN.compareTo(Float.POSITIVE_INFINITY)) // 1
    println(-0.0f == 0.0f) // true
    println((-0.0f).equals(0.0f)) // false
    println((-0.0f).compareTo(0.0f)) // -1
```

- return默认从最直接包围它的函数或者匿名函数返回。
- Nothing类型没有值，用来标记永远不可能到达的代码位置。