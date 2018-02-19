/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Item;
import DB.HibernateSession;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Chazool
 */
public class DBOrder {

    public static ArrayList<Item> SelectKeyType(String Text) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Item where ItemName like ? or Generic like ? or Barcord like ?");

        query.setString(0, Text + "%");

        query.setString(1, Text + "%");

        query.setString(2, Text + "%");

        ArrayList<Item> list = (ArrayList<Item>) query.list();

        transaction.commit();

        session.close();

        return list;
    }

}
