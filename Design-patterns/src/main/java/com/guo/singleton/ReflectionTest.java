package com.guo.singleton;


import java.lang.reflect.Constructor;

/**
 * Created by Tom.
 */
public class ReflectionTest {
    public static void main(String[] args) {
//        EnumSingleton instance = EnumSingleton.getInstance();
//        instance.setData(new Object());

        try {

            Class clazz = SingEnum.class;
            Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
            c.setAccessible(true);
            Object o = c.newInstance();
            System.out.println(o);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
