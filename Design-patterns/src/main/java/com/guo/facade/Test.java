package com.guo.facade;

/**
 * 门面模式
 * 对外暴露统一接口
 */
class Test {
    // 客户
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}