package com.donfyy.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static class A {
        void m() {
            System.out.printf("A.m");
        }
    }
    static final int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ h >>> 16;
    }
    public static void main(String... a) {
        int v = -1;
        System.out.println(v >> 1);
        System.out.println(v >>> 1);
        System.out.println(Integer.toBinaryString(v));
        System.out.println(Integer.toBinaryString(v >> 1));
        System.out.println(Integer.toBinaryString(v >>> 1));
        System.out.println(Integer.toBinaryString(Integer.valueOf(v).hashCode()));

        System.out.println(Integer.toBinaryString(hash(-1)));

        if (a.length != 0) {
            System.out.println("hhh");
        }
        /*Object proxyA = Proxy.newProxyInstance(
                A.class.getClassLoader(),
                new Class[]{A.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        return null;
                    }
                }
        );

        if (proxyA instanceof A) {
            ((A) proxyA).m();
        }*/
    }
}
