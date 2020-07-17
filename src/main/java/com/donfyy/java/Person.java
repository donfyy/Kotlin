package com.donfyy.java;

public class Person<T extends String> {
    private String name;

    private String firstProperty = createProperty(0);

    {
        System.out.println("init block 1");
    }


    {
        System.out.println("init block 2");
        System.out.println(name);
    }

    private String secondProperty = createProperty(1);
    public Person(String name) {
        this.name = name;
        System.out.println("constructor name:" + name);
    }

    private static String createProperty(int index) {
        String ret = "property " + (index + 1);
        System.out.println(ret);
        return ret;
    }

    public static void main(String... args) {
        new Person("donfyy");
    }


    public static class StaticPerson {

    }
}
