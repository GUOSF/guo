package com.guo.decorator.general;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

     void getBefore() {
        System.out.println("B+++");
    }

     void getEnd() {
        System.out.println("BB+++");
    }

    @Override
    public void operation() {
        getBefore();
        super.operation();
        getEnd();
    }
}