package com.nishad.springbootmysqlrestapi.services;

import com.nishad.springbootmysqlrestapi.exception.ResourceNotFoundException;
import com.nishad.springbootmysqlrestapi.model.student;
import com.nishad.springbootmysqlrestapi.repo.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServices {

    private final studentRepo studentrepo;

    @Autowired
    public studentServices(studentRepo studentrepo) {
        this.studentrepo = studentrepo;
    }

    public List<student> getAllStudents(){
        return studentrepo.findAll();
    }

    public student getStudentById(Long id){
        return studentrepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Student Not Found"));
    }
    public student setStudent(student student){
        return studentrepo.save(student);
    }

    public student updateStudent(Long id, student student) {
       student str = studentrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student Not Found"));
       str.setFirstName(student.getFirstName());
       str.setLastName(student.getLastName());
       str.setEmail(student.getEmail());
       str.setAge(student.getAge());
       return studentrepo.save(str);

    }

    public ResponseEntity<student> deletedStudent(Long id){
       student existStudent =   studentrepo.findById(id)
               .orElseThrow(()->new ResourceNotFoundException("Student Not Found"));

        studentrepo.delete(existStudent);
        return ResponseEntity.ok().build();
    }


}
