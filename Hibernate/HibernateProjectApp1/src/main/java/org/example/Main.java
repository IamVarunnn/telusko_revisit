package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    static void main() {


        Alien a1 = new Alien();
        a1.setAid(1);
        a1.setaName("Alex");
        a1.setTech("Go");

        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(org.example.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();





        Transaction transaction = session.beginTransaction();

        session.merge(a1);
        transaction.commit();




        session.close();
        sessionFactory.close();
    }
}
