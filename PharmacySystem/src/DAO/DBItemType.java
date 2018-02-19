/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.ItemType;
import DB.HibernateSession;
import java.util.ArrayList;
import newException.DatabaseException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Chazool
 */
public class DBItemType {

    /**
     * *
     * Save Or Update itemType Data
     *
     * @param itemType
     * @throws DatabaseException
     */
    public static void Save(ItemType itemType) throws DatabaseException {

        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.save(itemType);

            transaction.commit();

            session.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }

    }

    public static ArrayList<ItemType> Select() {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        ArrayList<ItemType> list = (ArrayList<ItemType>) session.createQuery("from ItemType").list();

        transaction.commit();

        session.close();

        return list;
    }

}
