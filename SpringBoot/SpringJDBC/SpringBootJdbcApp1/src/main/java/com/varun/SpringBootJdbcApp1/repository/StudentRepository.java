package com.varun.SpringBootJdbcApp1.repository;


import com.varun.SpringBootJdbcApp1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student s){

        String sql = "insert into student (rollno, name, marks) values (?, ?, ?)";


        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println(rows + " affected");
        System.out.println("Student Added");
    }

    public List<Student> findAll() {
        return new ArrayList<>();
    }
}
