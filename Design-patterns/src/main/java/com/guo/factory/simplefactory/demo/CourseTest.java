package com.guo.factory.simplefactory.demo;

import com.guo.factory.simplefactory.ICourse;
import com.guo.factory.simplefactory.JavaCourse;

/**
 * @author gsf
 * @date 2020/6/13 14:44
 */
public class CourseTest {
    public static void main(String[] args) {
        ICourseFactory ic = new ICourseFactory();
        ICourse iCourse = ic.create(JavaCourse.class);
        iCourse.record();
//        iCourse = ic.create(PythonCourse.class);
//        iCourse.record();
    }
}
