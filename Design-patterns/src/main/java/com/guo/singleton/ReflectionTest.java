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
//            Class clazz = EHanSingletion.class;
//            Constructor c = clazz.getDeclaredConstructor();
            c.setAccessible(true);
            Object o = c.newInstance();
            Object o1 = c.newInstance();
            System.out.println(o);
            System.out.println(o1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
