/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Item;
import Bean.Stock;
import DAO.DBItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;
import newException.nullDrugNameException;
import newException.nullGenericException;
import newException.nullItemIdException;
import newException.nullItemNameException;
import newException.nullResalpriceException;
import newException.nullTypeException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Chazool
 */
public class ItemManager extends CreateDataManager {

    private DBItem dbDrugsItem = new DBItem();

    /**
     * Check Item Data
     *
     * @param item
     * @throws nullItemNameException
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     * @throws nullDrugNameException
     * @throws nullResalpriceException
     */
    private static boolean Check(Item item, Stock stock) throws nullItemNameException, nullTypeException, nullItemIdException, nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullGenericException, nullResalpriceException {

        boolean bool = true;
        //Check Item Name
        if (item.getItemName() == null || item.getItemName().equals("")) {
            bool = false;
            throw new nullItemNameException();
        }

        //Check Item Type
        if (item.getType() == null || item.getType().equals("") || item.getType().equals(" ")) {
            bool = false;
            throw new nullTypeException();
        }
        //Check Item Generic
        if (item.getGeneric() == null || item.getGeneric().equals("") || item.getGeneric().equals(" ")) {
            bool = false;
            throw new nullGenericException();
        }
        //Check Item barcord
        if (item.getBarcord() == null) {
            item.setBarcord("");
        }
        //Check Stock Name
        if (stock.getItemName() == null || stock.getItemName().equals("")) {
            bool = false;
            throw new nullItemNameException();
        }

        //Check Stock Resale Price
        if (stock.getResalePrice() == 0) {
            bool = false;
            throw new nullResalpriceException();
        }
        checkCreateData(item);
        return bool;
    }

    /**
     * Save Item
     *
     * @param item
     * @return String Massage
     */
    public static String Save(Item item, Stock stock) throws ConstraintViolationException, nullItemNameException, nullTypeException, nullItemIdException, nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullGenericException, nullResalpriceException {

        String Message = "";

        //Set Create Data
        setCreteData(item);
        setCreteData(stock);
        //Check Item Data

        if (Check(item, stock)) {
            if (MessageManager.YesOrNoMessage("Are You Sure", "Add Item") == 0) {
                // Save Drugs Item
                DBItem.Save(item, stock);
            }
        }

        return Message;
    }

    /**
     * Update Drugs Item
     *
     * @param item
     * @return String ExceptionMassage
     */
    public String UpdateAll(Item item) {

        return null;
    }

    /**
     * *
     * Select All Drugs Item
     *
     * @return
     */
    public DefaultTableModel Select() {

        String TableTitle[] = new String[]{" ", "Item Name", "Barcorde", "Item Type", "Genaric"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, TableTitle);

        ArrayList<Item> list = dbDrugsItem.Select();

        Iterator<Item> iterator = list.iterator();
        Object row[] = new Object[5];
        int no = 0;
        while (iterator.hasNext()) {
            Item next = iterator.next();
            row[0] = ++no;
            row[1] = next.getItemName();
            row[2] = next.getBarcord();
            row[3] = next.getType();
            row[4] = next.getGeneric();

            model.addRow(row);

        }

        return model;
    }

    /**
     * *
     * Select Input Barcorde Value
     *
     * @param Barcorde
     * @return
     */
    public static Item Select(String Barcorde) {

        Item drugsItem = DBItem.Select(Barcorde);

        return drugsItem;
    }

    public static DefaultTableModel SelectKeyType(String Text) {

        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"", "Item Name"});

        ArrayList<Item> list = DBItem.SelectKeyType(Text);

        Iterator<Item> iterator = list.iterator();

        Object[] row = new Object[2];

        int no = 0;
        while (iterator.hasNext()) {
            Item next = iterator.next();
            row[0] = ++no;
            row[1] = next.getItemName();
            model.addRow(row);
        }

        return model;
    }

}
