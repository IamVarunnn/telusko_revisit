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


        Laptop l1 = session.find(Laptop.class, 71);
        System.out.println(l1);



        session.close();

        Session session1 = sessionFactory.openSession();
        Laptop l2 = session1.find(Laptop.class, 71);
        System.out.println(l2);

        session1.close();
        sessionFactory.close();
    }
}
