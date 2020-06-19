package com.guo.flyweight.jdk.integer;

/**
 * 享元模式 简单理解就是缓存模式
 */
public class IntegerTest {
    public static void main(String[] args) {

        Integer a = Integer.valueOf(100);
        Integer b = 100;

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println("a==b:" + (a==b));
        System.out.println("c==d:" + (c==d));
    }
}
