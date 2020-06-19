package com.guo.factory.abstractfactory.abstractfactory;


import com.guo.factory.abstractfactory.INote;
import com.guo.factory.abstractfactory.IVideo;
import com.guo.factory.abstractfactory.PythonNote;
import com.guo.factory.abstractfactory.PythonVideo;

/**
 * Created by Tom.
 */
public class PythonCourseFactory extends CourseFactory {

    public INote createNote() {
        super.init();
        return new PythonNote();
    }


    public IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
