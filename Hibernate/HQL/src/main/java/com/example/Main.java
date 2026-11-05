package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {

    static void main() {


        Laptop l1 = new Laptop();
        l1.setLid(881);
        l1.setBrand("Grand");
        l1.setModel("GY");
        l1.setRam(34);


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();



//        Laptop l2 = session.find(Laptop.class, 881);
//        System.out.println(l2);

        // select * from laptop where ram = 16
        // from laptop where ram = 16

        Query query = session.createQuery("from Laptop where ram = 16", Laptop.class);
        List<Laptop> res = query.getResultList();


        System.out.println(res);


        session.close();
        sessionFactory.close();
    }
}
