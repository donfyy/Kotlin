package com.donfyy.java;

//private static final int ABC=902;没有顶层属性，没有顶层函数，没有顶层常量
public class FilledRectangle extends Rectangle implements Polygon {
    // draw 方法不必重写

    public static void m1() {
    }

    public static void main(String... args) {
        FilledRectangle.m1();//可以使用子类类名调用父类静态方法

        Rectangle.m1();
    }
}
