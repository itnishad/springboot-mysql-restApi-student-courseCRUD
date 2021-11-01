package com.nishad.springbootmysqlrestapi.controller;

import com.nishad.springbootmysqlrestapi.model.student;
import com.nishad.springbootmysqlrestapi.services.studentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentController {



    private final studentServices studentservices;

    @Autowired
    public studentController(studentServices studentservices) {
        this.studentservices = studentservices;
    }

    @GetMapping("/allStudents")
    public List<student> getAllStudents(){
        return studentservices.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public student getStudentById(@PathVariable("id") Long id){
        return studentservices.getStudentById(id);
    }

    @PostMapping("/addStudent")
    public student addStudent(@RequestBody student student){
        return studentservices.setStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    public student updateStudent(@PathVariable("id") Long id, @RequestBody student str){
        return studentservices.updateStudent(id, str);
    }

    @DeleteMapping("/deletedStudent/{id}")
    public ResponseEntity<student> deletedStudent(@PathVariable Long id){
        return studentservices.deletedStudent(id);
    }
}
