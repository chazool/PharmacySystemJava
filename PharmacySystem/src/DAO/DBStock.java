/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.Item;
import Bean.Stock;
import Bean.StockBatch;
import DB.HibernateSession;
import Manager.MessageManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import newException.DatabaseException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Chazool
 */
public class DBStock {

    /**
     * *
     * Save or Update to DB Stock and Stock Batch
     *
     * @param stock
     * @param stockBatch
     * @throws DatabaseException
     */
    public static void SaveorUpdate(Stock stock, StockBatch stockBatch) throws DatabaseException {

        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            // Start Save Stock
            int StockQuantity = stock.getQuantity();

            Stock stockResult = (Stock) session.get(Stock.class, stock);

            stock.setQuantity(StockQuantity + stock.getQuantity());

            int StockBatchQty = stockBatch.getQuantity();

            // Start Save Or Update Stock Batch
            try {

                StockBatch StockBatchresult = (StockBatch) session.get(StockBatch.class, stockBatch);

                stockBatch.setQuantity(StockBatchQty + StockBatchresult.getQuantity());

                session.update(stockBatch);

            } catch (NullPointerException ex) {
                System.out.println("Save Stock Bach Data");
                session.save(stockBatch);

            }

            transaction.commit();

            session.close();

            MessageManager.SaveMessage("Save Success ", "Stock");

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();

        }
    }

    public static void main(String[] args) {
        try {
            Stock s = new Stock();
            s.setItemName("panadol Tablet");
            s.setResalePrice(1.5f);
            s.setQuantity(4);

            StockBatch sb = new StockBatch();
            sb.setCostPrice(1.5f);
            sb.setItemName("panadol Tablet");
            sb.setBatch("80");
            sb.setQuantity(10);

            SaveorUpdate(s, sb);
        } catch (DatabaseException ex) {
            Logger.getLogger(DBStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * *
     *
     * @param stock
     * @throws ConstraintViolationException
     */
    public static void Save(Stock stock) throws ConstraintViolationException {

        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            session.save(stock);

            transaction.commit();

            session.close();

            MessageManager.SaveMessage("Save Success ", "Stock");

        } catch (ConstraintViolationException ex) {
            ex.printStackTrace();
            throw ex;

        }
    }

    public static ArrayList<Stock> Select() throws DatabaseException {

        ArrayList<Stock> list = new ArrayList();
        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            list = (ArrayList<Stock>) session.createQuery("from Stock").list();

            transaction.commit();

            session.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DatabaseException();

        }

        return list;
    }

    /**
     * *
     * Select Use Key Type Stock
     *
     * @param Text
     * @return
     */
    public static ArrayList<Stock> SelectKeyType(String Text) {

        SessionFactory sessionFactory = HibernateSession.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Stock where ItemName like ?");

        query.setString(0, Text + "%");

        ArrayList<Stock> list = (ArrayList<Stock>) query.list();

        transaction.commit();

        session.close();

        return list;
    }

    public static ArrayList<Stock> Select(String Barcord) throws NullPointerException {

        ArrayList<Stock> list = null;

        try {
            SessionFactory sessionFactory = HibernateSession.getSessionFactory();

            Session session = sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            //Set Barcorde and Select Item
            Query query = session.createQuery("from Item where Barcord=?");
            query.setString(0, Barcord);
            Item item = (Item) query.uniqueResult();

            //Select Stock
            query = session.createQuery("from Stock where ItemName=?");
            query.setString(0, item.getItemName());
            list = (ArrayList<Stock>) query.list();

            transaction.commit();

            session.close();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            throw ex;
        }

        return list;
    }

}
