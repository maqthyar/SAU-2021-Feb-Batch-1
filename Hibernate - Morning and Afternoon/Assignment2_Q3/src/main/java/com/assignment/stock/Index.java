package com.assignment.stock;

import org.h2.engine.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Index
{
    public static void main(String[] args)
    {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();


        Shares s1 = new Shares(301,"P1");
        Shares s2 = new Shares(302,"P2");
        Shares s3 = new Shares(303,"P3");
        Shares s4 = new Shares(304,"P4");
        Shares s5 = new Shares(305,"P5");


        Users u1 = new Users(201,"C1");
        Users u2 = new Users(202,"C2");
        Users u3 = new Users(203,"C3");



        s1.setUser(u1);
        s2.setUser(u1);
        s3.setUser(u2);
        s4.setUser(u2);
        s5.setUser(u3);



        Transaction tx = session.beginTransaction();

        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);


        session.save(u1);
        session.save(u2);
        session.save(u3);

        tx.commit();
        session.close();

    }
}
