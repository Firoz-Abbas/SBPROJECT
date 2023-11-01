package com.onlyjavaboot.roz.services;

import com.onlyjavaboot.roz.intities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public Course addCourse(Course course) {
        List.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        List.forEach(e ->{
            if (e.getId()==course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        List=this.List.stream().filter(e -> e.getId()!=courseId).collect(Collectors.toList());
    }
}
