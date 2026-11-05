package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {


//        Laptop l1 = new Laptop();
//        l1.setLid(71);
//        l1.setBrand("HP");
//        l1.setModel("Pav");
//        l1.setRam(16);
//
//        Alien a1 = new Alien();
//        a1.setAid(1);
//        a1.setaName("Alex");
//        a1.setTech("Go");
//        a1.setLaptop(l1);
//
//        SessionFactory sessionFactory = new Configuration()
//                .addAnnotatedClass(org.example.Alien.class)
//                .addAnnotatedClass(org.example.Laptop.class)
//                .configure()
//                .buildSessionFactory();
//
//        Session session = sessionFactory.openSession();
//
//
//
//
//
//        Transaction transaction = session.beginTransaction();
//
//        session.persist(l1);
//        session.merge(a1);
//        transaction.commit();
//
//
//        Alien a2 = session.find(Alien.class, 1);
//        System.out.println(a2);
//
//
//        session.close();
//        sessionFactory.close();




        Bike b1 = new Bike();
        b1.setBikeId(301);
        b1.setBikeName("Honda");

        Student s1 = new Student();
        s1.setRollNo(101);
        s1.setsName("Ajay");
        s1.setsAge(19);
        s1.setBike(b1);


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Bike.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(b1);
        session.merge(s1);



        transaction.commit();


        session.close();
        sessionFactory.close();
    }
}
