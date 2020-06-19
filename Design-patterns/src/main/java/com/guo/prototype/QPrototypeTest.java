package com.guo.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式
 */
public class QPrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        QPrototype prototype = QPrototype.getInstance();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);

        //拷贝原型对象
        QPrototype cloneType = prototype.clone();
        cloneType.getHobbies().add("技术控");


        System.out.println("原型对象：" + prototype.toString());
        System.out.println("克隆对象：" + cloneType.toString());
        System.out.println(prototype);
        System.out.println(cloneType);
        System.out.println(prototype == cloneType);

    }
}
