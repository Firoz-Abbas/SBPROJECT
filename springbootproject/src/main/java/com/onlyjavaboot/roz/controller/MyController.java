package com.onlyjavaboot.roz.controller;


import com.onlyjavaboot.roz.intities.Course;
import com.onlyjavaboot.roz.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MyController {

    @Autowired
    private CourseServices courseServices;

    @GetMapping("/home")
    public String home()
    {
        return "This is home page";
    }
    // get the Courses

    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseServices.getCourses();
    }


    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseServices.getCourse(Long.parseLong(courseId));
    }
}
