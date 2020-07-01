package com.guo.template;

/**
 * 模板方法
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("=========架构师课程=========");
        JavaCourse java = new JavaCourse();
        java.setNeedCheckHomework(false);
        java.createCourse();


        System.out.println("=========Python课程=========");
        PythonCourse python = new PythonCourse();
        python.createCourse();
    }
}
