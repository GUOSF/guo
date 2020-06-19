package com.guo.factory.factorymethod.factorymethod;


import com.guo.factory.factorymethod.ICourse;
import com.guo.factory.factorymethod.PythonCourse;

/**
 * Created by Tom.
 */
public class PythonCourseFactory implements ICourseFactory {

    public ICourse create() {
        return new PythonCourse();
    }
}
