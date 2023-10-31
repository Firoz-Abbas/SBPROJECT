package com.onlyjavaboot.roz.services;

import com.onlyjavaboot.roz.intities.Courses;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseServicesImpl implements CourseServices {

    List<Courses> List;

    public CourseServicesImpl(){
        List = new ArrayList<>();
        List.add(new Courses(123, "Java Core Course", "This course contain basic of java"));
        List.add(new Courses(124, "Spring boot Course", "creating rest api using spring boot"));
    }


    @Override
    public List<Courses> getCourses() {
        return List;
    }
}
