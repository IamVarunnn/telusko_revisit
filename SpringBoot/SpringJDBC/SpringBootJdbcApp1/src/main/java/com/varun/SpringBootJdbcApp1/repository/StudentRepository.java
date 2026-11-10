package com.varun.SpringBootJdbcApp1.repository;


import com.varun.SpringBootJdbcApp1.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student s){
        System.out.println("Student Added");
    }
}
