package com.donfyy.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//private static final int ABC=902;没有顶层属性，没有顶层函数，没有顶层常量
public class FilledRectangle extends Rectangle implements Polygon {
    // draw 方法不必重写

    public static void m1() {
    }

    public static void main(String... args) {
        FilledRectangle.m1();//可以使用子类类名调用父类静态方法

        Rectangle.m1();

        List<? extends Object> c1;
        List<String> c2 = null;
        c1 = c2;
        Object o = c1.get(1);

        List<? super CharSequence> c3 = null;
        Object object = c3.get(0);
        c3.add("");
        c3.add(new CharSequence() {
            @Override
            public int length() {
                return 0;
            }

            @Override
            public char charAt(int i) {
                return 0;
            }

            @Override
            public CharSequence subSequence(int i, int i1) {
                return null;
            }
        });
    }
}
