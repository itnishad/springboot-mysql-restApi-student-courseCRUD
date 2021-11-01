package com.nishad.springbootmysqlrestapi.controller;

import com.nishad.springbootmysqlrestapi.model.course;
import com.nishad.springbootmysqlrestapi.services.courseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class courseController{

    public final courseServices courseservices;

    @Autowired
    public courseController(courseServices courseservices) {
        this.courseservices = courseservices;
    }

    @GetMapping("/allCourses")
    public List<course> getAllCourse(){
        return courseservices.getAllCourse();
    }

    @GetMapping("/getCourse/{id}")
    public course getCourse(@PathVariable("id") Long id){
        return courseservices.getCourseById(id);
    }

    @PostMapping("/addCourse")
    public course putCourse( @RequestBody course course){
        return courseservices.putCourse(course);
    }

    @PutMapping("/updateCourse/{id}")
    public course updateCourse(@PathVariable("id") Long id, @RequestBody course course){
        return courseservices.updateCourse(id, course);
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<course> deletedCourse(@PathVariable("id") Long id){
        return courseservices.deletedCourse(id);
    }

    @PutMapping("/course/{courseId}/student/{studentId}")
    public course enrollStudentToCourse(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId){
        System.out.println(courseId+"Hello");
        return courseservices.enrollStudentToCourse(courseId,studentId);
    }
}
