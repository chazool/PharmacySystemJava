/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Item;
import Bean.ItemType;
import DAO.DBItemType;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import newException.DatabaseException;
import newException.nullCategoryException;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;
import newException.nullItemNameException;

/**
 *
 * @author Chazool
 */
public class ItemTypeManager extends CreateDataManager {

    /**
     * *
     * Check Create Data And Item Type Data
     *
     * @param itemType
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     * @throws nullItemNameException
     */
    private static boolean Check(ItemType itemType) throws nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullItemNameException, nullCategoryException {
        boolean bool = true;
        if (itemType.getType() == null || itemType.getType().equals("") || itemType.getType().equals(" ")) {
            bool = false;
            throw new nullItemNameException();
        }

        if (itemType.getCategory() == null || itemType.getCategory().equals("") || itemType.getCategory().equals(" ")) {
            bool = false;
            throw new nullCategoryException();
        }

        //Check Create Data
        bool = checkCreateData(itemType);
        return bool;
    }

    /**
     * *
     * Save new ItemType
     *
     * @param itemType
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     * @throws nullItemNameException
     * @throws DatabaseException
     * @throws nullCategoryException
     */
    public static void Save(ItemType itemType) throws nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullItemNameException, DatabaseException, nullCategoryException {

        //Set Create Data
        setCreteData(itemType);

        //Check point
        if (Check(itemType)) {
            if (MessageManager.YesOrNoMessage("Are You Sure", "Item Type") == 0) {
                //Save or Update Database
                DBItemType.Save(itemType);
            }
        }

    }

    public static DefaultTableModel Select() {

        String TableTitle[] = new String[]{" ", "Item Type", "Category"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, TableTitle);

        ArrayList<ItemType> list = DBItemType.Select();

        Iterator<ItemType> iterator = list.iterator();
        Object row[] = new Object[3];
        int no = 0;
        while (iterator.hasNext()) {
            ItemType next = iterator.next();
            row[0] = ++no;
            row[1] = next.getType();
            row[2] = next.getCategory();
            ;

            model.addRow(row);

        }

        return model;
    }
}
