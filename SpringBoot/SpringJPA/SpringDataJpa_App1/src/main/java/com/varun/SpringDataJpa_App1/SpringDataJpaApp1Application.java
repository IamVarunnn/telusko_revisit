package com.varun.SpringDataJpa_App1;

import com.varun.SpringDataJpa_App1.model.Student;
import com.varun.SpringDataJpa_App1.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApp1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApp1Application.class, args);


		StudentRepository repo = context.getBean(StudentRepository.class);

		Student s1 = context.getBean(Student.class);
		s1.setRollNo(101);
		s1.setName("Rahul");
		s1.setMarks(85);

		Student s2 = context.getBean(Student.class);
		s2.setRollNo(102);
		s2.setName("Priya");
		s2.setMarks(90);

		Student s3 = context.getBean(Student.class);
		s3.setRollNo(103);
		s3.setName("Amit");
		s3.setMarks(78);

		repo.save(s1);
		repo.save(s2);
		repo.save(s3);

//		Student s = repo.findById(103).orElseThrow();
//		System.out.println(s);

//		List<Student> students = repo.findAll();
//
//		for(Student st : students){
//			System.out.println(st);
//		}


		repo.save(s2);

	}

}
