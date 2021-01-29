package com.donfyy.java;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FinalDemo {
    private int a;
    private final int b;
    private volatile int c;
    private static FinalDemo demo;

    public FinalDemo() {
        a = 1;
        b = 2;
    }

    public static void wirter() {
        demo = new FinalDemo();
        demo.c = 1;
        int c = demo.c;
    }

    public static void reader() {
        FinalDemo finalDemo = demo;
        int a = finalDemo.a;
        int b = finalDemo.b;
    }

    static class A {
        int a;

        public A(int a) {
            this.a = a;
        }
    }

    static class AA extends A {
        final int aa;

        public AA(int a, int aa) {
            super(a);
            this.aa = aa;
        }
    }

    static class B {
        int a;

        public B(int a) {
            this.a = a;
        }
    }

    static class BB extends B {
        final int aa;

        public BB(int a, int aa) {
            super(a);
            this.aa = aa;
        }
    }

    public static void main(String[] args) {
//        assert isDeepEquals(new String[]{"1"}, new String[]{"1"});
//        assert !isDeepEquals(new String[]{"1", "2"}, new String[]{"1"});
//        assert !isDeepEquals(false, new String[]{"1"});
//        assert !isDeepEquals(null, true);
//        assert isDeepEquals(new int[]{1, 2}, new int[]{1, 2});
//        assert !isDeepEquals(new int[]{1, 2}, new long[]{1, 2});
//        assert !isDeepEquals(new AA(1, 2), new AA(2, 2));
        System.out.println(isDeepEquals(new AA(1, 2), new AA(2, 2)));
//        assert !isDeepEquals(new AA(2, 2), new AA(2, 2));
//        System.out.println(new String[]{}.getClass());
//        System.out.println(new int[]{}.getClass());
//        System.out.println(new String[]{}.getClass().equals(new int[]{}.getClass()));
    }

    public static boolean isDeepEquals(Object src, Object dst) {
        if (src == dst) {
            return true;
        }
        if (src == null || dst == null) {
            return false;
        }
        if (src.getClass() != dst.getClass()) {
            return false;
        }

        if (src.getClass().isArray()) {
            final int n;
            if ((n = Array.getLength(src)) != Array.getLength(dst)) {
                return false;
            }
            for (int i = 0; i < n; i++) {
                if (!isDeepEquals(Array.get(src, i), Array.get(dst, i))) {
                    return false;
                }
            }
            return true;
        }

        // 因为方法名有了deep，我觉得应该是深比较哈，其实就是两个树的比较
        Class clazz = src.getClass();
        while (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if ((f.getModifiers() & Modifier.STATIC) != 0) {
                    continue;
                }
                try {
                    f.setAccessible(true);
                    if (!isDeepEquals(f.get(src), f.get(dst))) {
                        return false;
                    }
                } catch (Exception e) {
                }
            }
            clazz = null;
//            clazz = clazz.getSuperclass();
        }
        return true;
    }
}
