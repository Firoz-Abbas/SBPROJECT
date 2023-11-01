package com.onlyjavaboot.roz.services;

import com.onlyjavaboot.roz.intities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseServicesImpl implements CourseServices {

    List<Course> List;

    public CourseServicesImpl(){
        List = new ArrayList<>();
        List.add(new Course(123, "Java Core Course", "This course contain basic of java"));
        List.add(new Course(124, "Spring boot Course", "creating rest api using spring boot"));
    }


    @Override
    public List<Course> getCourses() {
        return List;
    }


    @Override
    public Course getCourse(Long courseId) {
        Course c=null;
        for (Course course: List){
            if (course.getId()==courseId){
                c = course;
                break;
            }
        }
        return c;
    }
}
