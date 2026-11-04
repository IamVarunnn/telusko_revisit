package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {

        Student s1 = new Student();
        s1.setRollNo(6);
        s1.setsName("Franky");
        s1.setsAge(20);


        Student s2 = null;

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        s2 = session.find(Student.class, 1);

        session.persist(s1);
        System.out.println(s2);




        session.close();
        sessionFactory.close();
    }
}
