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
        s1.setsAge(21);




        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        Transaction transaction = session.beginTransaction();

        session.merge(s1);
        System.out.println(s1);
        transaction.commit();




        session.close();
        sessionFactory.close();
    }
}
