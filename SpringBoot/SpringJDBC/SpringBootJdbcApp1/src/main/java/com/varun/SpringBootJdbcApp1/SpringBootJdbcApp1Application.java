package com.varun.SpringBootJdbcApp1;

import com.varun.SpringBootJdbcApp1.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApp1Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringBootJdbcApp1Application.class, args);

		Student s = context.getBean(Student.class);
		s.setRollNo(121);
		s.setName("Krish");
		s.setMarks(40);


	}

}
