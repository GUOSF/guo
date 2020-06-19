package com.guo.factory.factorymethod.factorymethod;


import com.guo.factory.factorymethod.ICourse;
import com.guo.factory.factorymethod.JavaCourse;

/**
 * Created by Tom.
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        return new JavaCourse();
    }
}
