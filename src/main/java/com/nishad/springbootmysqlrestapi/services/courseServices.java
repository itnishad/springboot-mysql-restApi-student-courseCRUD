package com.nishad.springbootmysqlrestapi.services;

import com.nishad.springbootmysqlrestapi.exception.ResourceNotFoundException;
import com.nishad.springbootmysqlrestapi.model.course;
import com.nishad.springbootmysqlrestapi.model.student;
import com.nishad.springbootmysqlrestapi.repo.courseRepo;
import com.nishad.springbootmysqlrestapi.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseServices {
    private final courseRepo courseRepo;
    private  final studentRepo studentrepo;

    @Autowired
    public courseServices(courseRepo courseRepo, studentRepo studentrepo) {
        this.courseRepo = courseRepo;
        this.studentrepo = studentrepo;
    }

    public List<course> getAllCourse(){
        return courseRepo.findAll();
    }

    public course getCourseById(Long id){
        return courseRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Course Not Found"));
    }
    public course putCourse(course course){
        return courseRepo.save(course);
    }
    public course updateCourse(long id,course course){
        course existCourse = courseRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Course Not Found"));
        existCourse.setCourseName(course.getCourseName());
        return courseRepo.save(existCourse);
    }
    public ResponseEntity<course> deletedCourse(Long id){
        course existCourse = courseRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Course Not Found"));

        courseRepo.delete(existCourse);
        return ResponseEntity.ok().build();
    }

    public course enrollStudentToCourse(Long courseId, Long studentId){
        course existC = courseRepo.findById(courseId)
                .orElseThrow(()->new ResourceNotFoundException("Course Not Found"));
        student existS = studentrepo.findById(studentId)
                .orElseThrow(()->new ResourceNotFoundException("Course Not Found"));

        existC.enrollStudent(existS);
        return courseRepo.save(existC);
    }
}
