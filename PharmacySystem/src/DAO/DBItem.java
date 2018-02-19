/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Item;
import Bean.Stock;
import DB.HibernateSession;
import Manager.MessageManager;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author pcpal
 */
public class DBItem {

    /**
     * Save Drugs Item
     *
     * @param item
     * @param stock
     * @return boolean
     */
    public static boolean Save(Item item, Stock stock) throws ConstraintViolationException {

        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction tr = session.beginTransaction();

            session.save(item);

            session.save(stock);

            tr.commit();

            session.close();

            MessageManager.SaveMessage("Drugs Item Save Success \n" + "Item Name" + item.getItemName(), "Save Item");
        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            throw ex;

        }

        return false;
    }

    /**
     * Get All Drugs Item
     *
     * @return
     */
    public ArrayList<Item> Select() {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Item");

        ArrayList<Item> list = (ArrayList<Item>) query.list();

        transaction.commit();

        session.close();

        return list;
    }

    public static Item Select(String Brarcord) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Item where Barcord=?");
        query.setString(0, Brarcord);

        Item drugsItem = (Item) query.uniqueResult();

        transaction.commit();

        session.close();

        return drugsItem;
    }

    public static ArrayList<Item> SelectKeyType(String Text) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Item where ItemName like ?");

        query.setString(0, Text + "%");

        ArrayList<Item> list = (ArrayList<Item>) query.list();

        transaction.commit();

        session.close();

        return list;
    }
}
