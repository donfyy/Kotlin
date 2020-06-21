package com.donfyy.java;

public class ProxyTest {
    public static class A {
        void m() {
            System.out.printf("A.m");
        }
    }

    public static void main(String... a) {
        System.out.println(1 ^ 1);
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
