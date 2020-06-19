package com.guo.factory.simplefactory.demo;

import com.guo.factory.simplefactory.ICourse;

/**
 * @author gsf
 * @date 2020/6/13 14:43
 */
public class ICourseFactory {

    public ICourse create(Class<? extends ICourse> clazz) {

        try {
            if (clazz != null) {
                return clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
