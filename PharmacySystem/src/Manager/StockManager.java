/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Stock;
import Bean.StockBatch;
import DAO.DBStock;
import GUI.GUIAddStock;
import GUI.GUIPopupTable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import newException.DatabaseException;
import newException.nullBatchNoException;
import newException.nullCostPriceException;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;
import newException.nullExpDateException;
import newException.nullItemNameException;
import newException.nullQuantityException;
import newException.nullResalpriceException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Chazool
 */
public class StockManager extends CreateDataManager {

    /**
     * *
     * Save and Update Stock Data Check Point
     *
     * @param stock
     * @param stockBatch
     * @return
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     * @throws nullItemNameException
     * @throws nullBatchNoException
     * @throws nullCostPriceException
     * @throws nullExpDateException
     * @throws nullQuantityException
     * @throws nullResalpriceException
     */
    private static boolean Check(Stock stock, StockBatch stockBatch) throws nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullItemNameException, nullBatchNoException, nullCostPriceException, nullExpDateException, nullQuantityException, nullResalpriceException {
        boolean bool = true;

        //Check Item Name
        if (stock.getItemName() == null || stock.getItemName().equals("") || stock.getItemName().equals(" ")) {
            bool = false;
            throw new nullItemNameException();
        }

        if (stockBatch.getItemName() == null || stockBatch.getItemName().equals("") || stockBatch.getItemName().equals(" ")) {
            bool = false;
            throw new nullItemNameException();
        }

        //Check Batch No
        if (stockBatch.getBatch() == null || stockBatch.getBatch().equals("") || stockBatch.getBatch().equals(" ")) {
            bool = false;
            throw new nullBatchNoException();
        }
        //Check Cost Price
        if (stockBatch.getCostPrice() == 0 || stockBatch.getCostPrice() > 100000) {
            bool = false;
            throw new nullCostPriceException();
        }
        //Check Exp Date
        if (stockBatch.getEXPDate() == null || stockBatch.getEXPDate().equals("") || stockBatch.getEXPDate().equals(" ")) {
            bool = false;
            throw new nullExpDateException();
        }
        //Check Qty
        if (stock.getQuantity() == 0 || stock.getQuantity() > 100000) {
            bool = false;
            throw new nullQuantityException();
        }

        if (stockBatch.getQuantity() == 0 || stockBatch.getQuantity() > 100000) {
            bool = false;
            throw new nullQuantityException();
        }

        if (stock.getResalePrice() == 0 || stock.getResalePrice() > 100000) {
            bool = false;
            throw new nullResalpriceException();
        }
        //Check Create Data
        bool = checkCreateData(stock);

        return bool;
    }

    /**
     * *
     * Save or Update Stock and Stock BatchS
     *
     * @param stock
     * @param stockBatch
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     * @throws nullItemNameException
     * @throws nullBatchNoException
     * @throws nullCostPriceException
     * @throws nullExpDateException
     * @throws nullQuantityException
     * @throws DatabaseException
     * @throws nullResalpriceException
     */
    public static void SaveorUpdate(Stock stock, StockBatch stockBatch) throws nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullItemNameException, nullBatchNoException, nullCostPriceException, nullExpDateException, nullQuantityException, DatabaseException, nullResalpriceException {

        //set Create Data
        setCreteData(stock);
        setCreteData(stockBatch);
        if (Check(stock, stockBatch)) {
            DBStock.SaveorUpdate(stock, stockBatch);
        }

    }

    /**
     * *
     * Stock Data Check point
     *
     * @param stock
     * @return
     * @throws nullItemNameException
     * @throws nullResalpriceException
     */
    private static boolean Check(Stock stock) throws nullItemNameException, nullResalpriceException {
        boolean bool = true;
        //Check Item Name
        if (stock.getItemName() == null || stock.getItemName().equals("") || stock.getItemName().equals(" ")) {
            bool = false;
            throw new nullItemNameException();
        }

        //Check Item Name
        if (stock.getResalePrice() == 0) {
            bool = false;
            throw new nullResalpriceException();
        }
        return bool;

    }

    /**
     * *
     * Save or Update Stock
     *
     * @param stock
     * @throws nullItemNameException
     * @throws nullResalpriceException
     * @throws DatabaseException
     */
    public static void Save(Stock stock) throws nullItemNameException, nullResalpriceException, ConstraintViolationException {
        setCreteData(stock);

        if (Check(stock)) {
            if (MessageManager.YesOrNoMessage("Are You Sure", "Add Stock") == 0) {
                DBStock.Save(stock);
            }
        }

    }

    /**
     * Select All Stock
     *
     * @return DefaultTableModel
     * @throws DatabaseException
     */
    public static DefaultTableModel Select() throws DatabaseException {
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"", "Item Name", "Resale Price", "Qty"});

        Object row[] = new Object[4];

        ArrayList<Stock> list = DBStock.Select();

        Iterator<Stock> iterator = list.iterator();
        int no = 0;
        while (iterator.hasNext()) {
            Stock next = iterator.next();
            row[0] = ++no;
            row[1] = next.getItemName();
            row[2] = next.getResalePrice();
            row[3] = next.getQuantity();

            model.addRow(row);

        }

        return model;
    }

    /**
     * *
     * Select Use Key Type
     *
     * @param Text
     * @return DefaultTableModel
     */
    public static DefaultTableModel SelectKeyType(String Text) {

        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"", "Item Name", "Resale Price"});

        ArrayList<Stock> list = DBStock.SelectKeyType(Text);

        Iterator<Stock> iterator = list.iterator();

        Object row[] = new Object[3];
        int no = 0;
        while (iterator.hasNext()) {
            Stock next = iterator.next();
            row[0] = ++no;
            row[1] = next.getItemName();
            row[2] = next.getResalePrice();

            model.addRow(row);

        }

        return model;
    }

    
    /**
     * Set Barcode and get Stock and Set Item Name And Resale Price
     * @param Barcode
     * @param gui
     * @return
     * @throws NullPointerException 
     */
    public static Stock Select(String Barcode, JFrame gui) throws NullPointerException {

        GUIPopupTable gUIPopupTable = new GUIPopupTable();

        ArrayList<Stock> list = DBStock.Select(Barcode);
        GUIAddStock guiAddStock = (GUIAddStock) gui;
        if (list.size() == 1) {
            guiAddStock.SetItem(list.get(0).getItemName(), list.get(0).getResalePrice());
        } else {
            gUIPopupTable.Show("StockBarcode", gui);
            gui.disable();
            gUIPopupTable.SetBarcode(Barcode, list);
        }

        return null;
    }
}
