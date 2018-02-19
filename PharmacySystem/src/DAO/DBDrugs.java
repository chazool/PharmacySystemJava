/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Drugs;
import DB.HibernateSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Chazool
 */
public class DBDrugs {

    /**
     * Save Database Drugs Data
     *
     * @param drugs
     * @return boolean
     */
    public boolean Save(Drugs drugs) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
       
        drugs.setDrugsId(3);

        session.saveOrUpdate(drugs);

        tx.commit();

        session.close();

        return false;
    }

}
