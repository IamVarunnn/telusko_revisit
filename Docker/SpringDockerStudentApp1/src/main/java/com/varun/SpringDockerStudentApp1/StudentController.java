package com.varun.SpringDockerStudentApp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @PostMapping("/students")
    public void addStudent(){
        Student s = new Student();
        s.setAge(19);
        s.setName("Raj");
        studentRepo.save(s);
    }
}
