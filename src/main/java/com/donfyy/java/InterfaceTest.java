package com.donfyy.java;

public class InterfaceTest {

    public interface A {
        default void m1() {

        }
    }

    public interface B {
        default void m1() {

        }
    }

    public interface C {
        void m1();
    }

    public interface D {

    }

    public interface IIA extends B, C {
        @Override
        void m1();
    }

    public interface IIB extends C, D {
//        对于接口，其实现的多个接口里存在相同签名的方法，若这些方法都没有实现，则在接口中不用重写
//        若其中一个方法有实现，在接口中必须重写
    }

    private static class CA implements A {
//        接口中的某个方法提供了默认实现，那么在接口的实现类中不必在提供改方法的实现，
    }

    private static class CC implements A, C {

        @Override
        public void m1() {
//         实现类实现的其他接口中也存在相同签名的方法，则实现类必须实现该方法。
//            对于类，其实现了多个接口，如果某一个方法在这些接口中只出现一次，并且这个方法有默认实现，那么类可以不用重写该方法。
        }
    }

    private static class CB implements A, B {

        @Override
        public void m1() {
            A.super.m1();
            B.super.m1();
//            可以通过这种方式访问接口中的方法
        }
    }
}
