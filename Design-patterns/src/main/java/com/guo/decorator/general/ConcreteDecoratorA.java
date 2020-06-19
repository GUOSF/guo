package com.guo.decorator.general;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }
     void getBefore(){
        System.out.println("A+++");
    }
     void getEnd(){
        System.out.println("AA+++");
    }
    @Override
    public void operation() {
        getBefore();
        super.operation();
        getEnd();
    }
}