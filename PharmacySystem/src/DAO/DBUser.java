/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.User;
import DB.HibernateSession;
import javax.swing.JProgressBar;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Chazool
 */
public class DBUser {

    /**
     * Save User Data To DB
     *
     * @param user
     * @return
     */
    public boolean Save(User user) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tr = session.beginTransaction();

        session.save(user);

        tr.commit();

        session.close();

        return false;
    }

    /**
     * Select Password
     *
     * @param user
     * @return
     */
    public static String Select(String user, JProgressBar bar) throws NullPointerException {

        User result = null;
        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();
            bar.setValue(30);

            Session session = sessionFactory.openSession();
            bar.setValue(40);
            Transaction tr = session.beginTransaction();

            Query query = session.createQuery("from User where UserName=?");
            bar.setValue(50);
            query.setString(0, user);
            bar.setValue(60);
            result = (User) query.uniqueResult();
            bar.setValue(70);
            tr.commit();

            session.close();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            throw new NullPointerException();
        }

        return result.getPassword();
    }
}
