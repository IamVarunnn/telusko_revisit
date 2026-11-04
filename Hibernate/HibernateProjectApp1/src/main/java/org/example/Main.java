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

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(org.example.Student.class);
//        cfg.configure();


//        SessionFactory sessionFactory = cfg.buildSessionFactory();

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        session.persist(s1);
        transaction.commit();


        System.out.println(s1);




        session.close();
        sessionFactory.close();
    }
}
