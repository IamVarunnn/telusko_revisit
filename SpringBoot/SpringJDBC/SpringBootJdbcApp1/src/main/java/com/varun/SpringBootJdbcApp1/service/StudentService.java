package com.varun.SpringBootJdbcApp1.service;


import com.varun.SpringBootJdbcApp1.model.Student;
import com.varun.SpringBootJdbcApp1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public void addStudent(Student s){
        repo.save(s);
    }
}
