package com.onlyjavaboot.roz.dao;

import com.onlyjavaboot.roz.intities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {

}
