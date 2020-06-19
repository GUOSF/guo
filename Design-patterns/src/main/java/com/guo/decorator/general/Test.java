package com.guo.decorator.general;

/**
 * @author gsf
 * @date 2020/6/17 17:20
 */
public class Test {
    public static void main(String[] args) {
        Component c = new ConcreteComponent();
        Decorator a = new ConcreteDecoratorA(c);
        Decorator b = new ConcreteDecoratorB(a);
        b.operation();

    }
}
