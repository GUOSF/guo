package com.guo.template;

/**
 * @author gsf
 * @date 2020/6/29 16:10
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.TemplateMethod();
    }
}

//抽象类
abstract class AbstractClass {
    public void TemplateMethod() //模板方法
    {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void SpecificMethod() //具体方法
    {
        System.out.println("抽象类中的具体方法被调用...");
    }

    public abstract void abstractMethod1(); //抽象方法1

    public abstract void abstractMethod2(); //抽象方法2
}

//具体子类
class ConcreteClass extends AbstractClass {
    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }
    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
