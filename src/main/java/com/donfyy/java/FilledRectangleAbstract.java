package com.donfyy.java;

//可以把基类中已经实现的方法声明为abstract
//可以用一个抽象成员覆盖一个非抽象成员
public abstract class FilledRectangleAbstract extends Rectangle implements Polygon {
    @Override
    public abstract void draw();
    // draw 方法不必重写
}
