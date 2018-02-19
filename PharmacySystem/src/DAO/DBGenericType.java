/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Generic;
import Bean.GenericType;
import DB.HibernateSession;
import java.util.ArrayList;
import newException.DatabaseException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Chazool
 */
public class DBGenericType {

    /**
     * *
     * Save or Update Generic Type to Database
     *
     * @param genericType
     * @throws DatabaseException
     */
    public static void SaveorUpdate(GenericType genericType) throws DatabaseException {
        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.saveOrUpdate(genericType);

            transaction.commit();

            session.close();

        } catch (Exception ex) {
            //ex.printStackTrace();
            throw new DatabaseException();
        }
    }

    /**
     * *
     * Select all Generic Type
     *
     * @return ArrayList<GenericType>
     * @throws DatabaseException
     */
    public static ArrayList<GenericType> Select() throws DatabaseException {

        ArrayList<GenericType> list;
        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            list = (ArrayList<GenericType>) session.createQuery("from GenericType").list();

            transaction.commit();

            session.close();

        } catch (Exception ex) {
            //ex.printStackTrace();
            throw new DatabaseException();
        }

        return list;
    }

    public static ArrayList<GenericType> Select(String Category) throws DatabaseException {

        ArrayList<GenericType> list = null;
        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

          //  Generic resultGeneric = (Generic) session.get(Generic.class, generic);
            
            Query query = session.createQuery("from GenericType where Category=?");

            query.setString(0, Category);
            list = (ArrayList<GenericType>) query.list();

            System.out.println(list.get(0).getGenericTypeName());

            transaction.commit();

            session.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();
        }

        return list;
    }
}
