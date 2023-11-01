package com.onlyjavaboot.roz.services;
import com.onlyjavaboot.roz.intities.Course;
import java.util.List;

import java.awt.*;

public interface CourseServices {

    public List<Course> getCourses();
    public Course getCourse(Long courseId);
}
