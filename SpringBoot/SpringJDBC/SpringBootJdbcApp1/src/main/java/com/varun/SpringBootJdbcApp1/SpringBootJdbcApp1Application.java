package com.varun.SpringBootJdbcApp1;

import com.varun.SpringBootJdbcApp1.model.Student;
import com.varun.SpringBootJdbcApp1.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApp1Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBootJdbcApp1Application.class, args);

		Student s = context.getBean(Student.class);
		s.setRollNo(121);
		s.setName("Krish");
		s.setMarks(40);

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
