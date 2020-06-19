package com.guo.factory. abstractfactory.abstractfactory;


import com.guo.factory.abstractfactory.INote;
import com.guo.factory.abstractfactory.IVideo;
import com.guo.factory.abstractfactory.JavaNote;
import com.guo.factory.abstractfactory.JavaVideo;

/**
 * Created by Tom.
 */
public class JavaCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new JavaNote();
    }

    public IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
