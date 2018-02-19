/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Generic;
import Bean.Student;
import Bean.User;
import DB.HibernateSession;
import java.awt.List;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author PCPAL
 */
public class TestDB {

    public boolean Save(Student std) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(std);

        tx.commit();

        session.close();

        return false;
    }

    public boolean Select(Student std) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        /*Student s=(Student) session.load(Student.class, new Integer(1));
        
         System.out.println(s.getId()+"  "+s.getName());
         */
        Query queryResult = session.createQuery("from Student");

        tx.commit();

        ArrayList<Student> allUsers = (ArrayList<Student>) queryResult.list();
       
        for (int i = 0; i < allUsers.size(); i++) {
            Student user = (Student) allUsers.get(i);
            System.out.println(user);
        }
        session.close();
        return false;
    }

}
