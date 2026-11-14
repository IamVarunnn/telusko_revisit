package com.varun.SpringDataJpa_App1.repository;


import com.varun.SpringDataJpa_App1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
