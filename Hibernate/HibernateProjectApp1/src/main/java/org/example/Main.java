package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    static void main() {


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

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();





        Transaction transaction = session.beginTransaction();

        session.merge(l1);
        session.persist(l2);
        session.persist(l3);
        session.merge(a1);
        transaction.commit();



        session.close();
        sessionFactory.close();





    }
}
