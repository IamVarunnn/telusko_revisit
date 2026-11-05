package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


public class Main {

    static void main() {





        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();


        Laptop l1 = session.getReference(Laptop.class, 71);
//        System.out.println(l1);

        session.close();
        sessionFactory.close();
    }
}
