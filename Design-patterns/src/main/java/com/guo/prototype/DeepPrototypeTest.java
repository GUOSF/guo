package com.guo.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gsf
 * @date 2020/6/14 19:08
 */
public class DeepPrototypeTest {

    public static void main(String[] args) {
        //创建原型对象
        DeepPrototype prototype = new DeepPrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);

        //拷贝原型对象
        DeepPrototype cloneType = prototype.clone();
        cloneType.getHobbies().add("技术控");
        cloneType.setAge(19);
        cloneType.setName("www");

        System.out.println("原型对象：" + prototype);
        System.out.println("克隆对象：" + cloneType);
        System.out.println(prototype == cloneType);


        System.out.println("原型对象的爱好：" + prototype.getHobbies());
        System.out.println("克隆对象的爱好：" + cloneType.getHobbies());
        System.out.println(prototype.getHobbies() == cloneType.getHobbies());

    }
}
