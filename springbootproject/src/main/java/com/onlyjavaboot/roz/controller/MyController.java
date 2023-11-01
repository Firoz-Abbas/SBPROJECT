package com.onlyjavaboot.roz.controller;


import com.onlyjavaboot.roz.intities.Course;
import com.onlyjavaboot.roz.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //get single course by id
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseServices.getCourse(Long.parseLong(courseId));
    }

    // Add course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseServices.addCourse(course);
    }

    //Update course using put request
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseServices.updateCourse(course);
    }

    //Delete the course
//    @DeleteMapping("/courses/{courseId}")
//    public void deleteCourse(@PathVariable String courseId){
//         this.courseServices.deleteCourse(Long.parseLong(courseId));
//    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseServices.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
