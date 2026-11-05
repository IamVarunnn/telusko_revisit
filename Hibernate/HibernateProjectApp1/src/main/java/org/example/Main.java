package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    static void main(String[] args) {


        Laptop l1 = new Laptop();
        l1.setLid(71);
        l1.setBrand("HP");
        l1.setModel("Pav");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(72);
        l2.setBrand("Dell");
        l2.setModel("15");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(73);
        l3.setBrand("Acer");
        l3.setModel("Nitro");
        l3.setRam(16);





        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setaName("Alex");
        a1.setTech("Go");
        a1.setLaptops(Arrays.asList(l1, l2, l3));


        Alien a2 = new Alien();
        a2.setAid(2);
        a2.setaName("Bob");
        a2.setTech("Py");
        a2.setLaptops(Arrays.asList(l1, l2));

        Alien a3 = new Alien();
        a3.setAid(3);
        a3.setaName("Carry");
        a3.setTech("JS");
        a3.setLaptops(Arrays.asList(l3));


        l1.setAliens(Arrays.asList(a1, a2));
        l2.setAliens(Arrays.asList(a1, a2));
        l3.setAliens(Arrays.asList(a1, a3));


        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();





        Transaction transaction = session.beginTransaction();


        session.persist(l1);
        session.persist(l2);
        session.persist(l3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        transaction.commit();



        session.close();
        sessionFactory.close();





    }
}
