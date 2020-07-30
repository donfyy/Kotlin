package com.donfyy.java;

class Test {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String... args) {
        System.out.println("2:" + Integer.toBinaryString(2) + " idx:" + Integer.toBinaryString(2 & 7) + " new Idx:" + Integer.toBinaryString(2 & 15));
        System.out.println("10:" + Integer.toBinaryString(10) + " idx:" + Integer.toBinaryString(10 & 7) + " new Idx:" + Integer.toBinaryString(10 & 15));
        System.out.println("18:" + Integer.toBinaryString(18) + " idx:" + Integer.toBinaryString(18 & 7) + " new Idx:" + Integer.toBinaryString(18 & 15));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}