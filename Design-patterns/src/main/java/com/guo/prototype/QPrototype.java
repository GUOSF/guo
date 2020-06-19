package com.guo.prototype;

import lombok.Data;

import java.util.List;

/**
 * @author gsf
 * @date 2020/6/14 19:10
 */
@Data
public class QPrototype implements Cloneable {
    private int age;
    private String name;
    private List<String> hobbies;

    private static  QPrototype instance = new QPrototype();

    private QPrototype(){}

    public static QPrototype getInstance(){
        return instance;
    }

    @Override
    public QPrototype clone() {
        return instance;
    }

}
