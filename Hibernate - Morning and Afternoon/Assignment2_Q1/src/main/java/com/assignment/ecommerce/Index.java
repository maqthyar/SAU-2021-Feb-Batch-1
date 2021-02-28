package com.assignment.ecommerce;

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


        Product p1 = new Product(301,"P1");
        Product p2 = new Product(302,"P2");
        Product p3 = new Product(303,"P3");
        Product p4 = new Product(304,"P4");


        Categories c1 = new Categories(201,"C1");
        Categories c2 = new Categories(202,"C2");
        Categories c3 = new Categories(203,"C3");

        Supplier s1 = new Supplier(401,"S1");
        Supplier s2 = new Supplier(402,"S2");
        Supplier s3 = new Supplier(403,"S3");



        p1.setCategory(c1);
        p2.setCategory(c2);
        p3.setCategory(c3);
        p4.setCategory(c1);

        Set<Categories> st1 = new HashSet<>();
        Set<Categories> st2 = new HashSet<>();
        Set<Categories> st3 = new HashSet<>();

        st1.add(c1);
        st1.add(c2);
        s1.setCategories(st1);

        st2.add(c2);
        st2.add(c3);
        s2.setCategories(st2);

        st3.add(c3);
        st3.add(c1);
        s3.setCategories(st3);

        Set<Supplier> st4 = new HashSet<>();
        Set<Supplier> st5 = new HashSet<>();
        Set<Supplier> st6 = new HashSet<>();

        st4.add(s1);
        st4.add(s3);

        st5.add(s1);
        st5.add(s2);

        st6.add(s2);
        st6.add(s3);

        c1.setSupplier(st4);
        c2.setSupplier(st5);
        c3.setSupplier(st6);


        Transaction tx = session.beginTransaction();

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);

        session.save(c1);
        session.save(c2);
        session.save(c3);

        session.save(s1);
        session.save(s2);
        session.save(s3);

        tx.commit();
        session.close();

    }
}
