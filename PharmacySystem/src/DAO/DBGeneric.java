/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Generic;
import DB.HibernateSession;
import Manager.MessageManager;
import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Chazool
 */
public class DBGeneric {

    /**
     * Save Database Drugs Data
     *
     * @param generic
     * @return boolean
     */
    public ArrayList<Generic> SaveorUpdate(Generic generic) {

        ArrayList<Generic> list = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();

            session.saveOrUpdate(generic);

            list = (ArrayList<Generic>) session.createQuery("from Generic").list();

            tx.commit();

            session.close();

            MessageManager.SaveMessage("Genaric Data Save Success \n Generic Name :" + generic.getGenericName(), "Generic Save");
        } catch (Exception ex) {

        }

        return list;
    }

    /**
     * Select All Drugs Data
     *
     * @return ArrayList<Generic>
     */
    public static ArrayList<Generic> Select() {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Generic");

        ArrayList<Generic> list = (ArrayList<Generic>) query.list();

        tx.commit();

        session.close();

        return list;
    }

    /**
     * *
     * User Input DrugsId And Select Drugs Data
     *
     * @param GenaricName
     * @return Drugs
     */
    public static Generic Select(String GenaricName) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        Generic drugs = (Generic) session.get(Generic.class, GenaricName);

        tx.commit();

        session.close();

        return drugs;
    }

    public static ArrayList<Generic> SelectKeyType(String Text) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from Generic where GenericName like ?");

        query.setString(0, Text + "%");

        ArrayList<Generic> list = (ArrayList<Generic>) query.list();

        tx.commit();

        session.close();

        return list;
    }

}
