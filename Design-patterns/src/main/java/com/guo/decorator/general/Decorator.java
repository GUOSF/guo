package com.guo.decorator.general;

/**
 * @author gsf
 * @date 2020/6/17 16:58
 */
public abstract class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    abstract void getBefore();
    abstract void getEnd();
    public void operation() {
        component.operation();
    }
}
