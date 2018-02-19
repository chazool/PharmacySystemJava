/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.GenericType;
import DAO.DBGenericType;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;
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
public class GenericTypeManager extends CreateDataManager {

    /**
     * Generic type Check Point
     *
     * @param genericType
     * @return boolean
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     * @throws nullItemNameException
     * @throws nullCategoryException
     */
    private static boolean Check(GenericType genericType) throws nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullItemNameException, nullCategoryException {
        
        boolean bool = true;

        //Cehck Create Data
        checkCreateData(genericType);

        //check Generic Name
        if (genericType.getGenericTypeName() == null || genericType.getGenericTypeName().equals("") || genericType.getGenericTypeName().equals(" ")) {
            
           bool = false;
            throw new nullItemNameException();
        }

        //Chech Category
        if (genericType.getCategory() == null || genericType.getCategory().equals("") || genericType.getCategory().equals(" ")) {
            bool = false;
            throw new nullCategoryException();
        }
        
        return bool;
    }

    /**
     * *
     * Save or Update Generic Type Data
     *
     * @param genericType
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullItemNameException
     * @throws nullCreateTimeException
     * @throws DatabaseException
     */
    public static void SaveOrUpdate(GenericType genericType) throws nullCreateUserException, nullCreateDateException, nullItemNameException, nullCreateTimeException, DatabaseException, nullCategoryException {

        //SetCreate Data
        genericType.setCreateDate();
        genericType.setCreateTime();
        genericType.setCreateUser("Chazool");
        // Genaric Data
        if (Check(genericType)) {
            if (MessageManager.YesOrNoMessage("Are You Sure", "Add Generic Type") == 0) {
                //Save or Update Database
                DBGenericType.SaveorUpdate(genericType);
            }
        }
        
    }

    /**
     * *
     * Select All Generic Type
     *
     * @return DefaultTableModel
     * @throws DatabaseException
     */
    public static DefaultTableModel Select() throws DatabaseException {
        
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"", "Generic Type", "Category"});
        ArrayList<GenericType> list = DBGenericType.Select();
        
        Iterator<GenericType> iterator = list.iterator();
        
        Object[] row = new Object[3];
        int no = 0;
        while (iterator.hasNext()) {
            GenericType next = iterator.next();
            row[0] = ++no;
            row[1] = next.getGenericTypeName();
            row[2] = next.getCategory();
            model.addRow(row);
        }
        
        return model;
    }

    /**
     * set Generic And get Generic type
     *
     * @param generic
     * @return DefaultComboBoxModel
     * @throws DatabaseException
     */
    public static DefaultComboBoxModel Select(String Category) throws DatabaseException {
        
        DefaultComboBoxModel model = getComboBoxModel(DBGenericType.Select(Category));
        
        return model;
    }

    /**
     * Select All Generic Type
     *
     * @return DefaultComboBoxModel
     * @throws DatabaseException
     */
    public static DefaultComboBoxModel SelectGenericType() throws DatabaseException {
        
        DefaultComboBoxModel model = getComboBoxModel(DBGenericType.Select());
        
        return model;
    }

    /**
     * *
     * Set ArrayList and get ComboBox Model
     *
     * @param list
     * @return DefaultComboBoxModel
     */
    private static DefaultComboBoxModel getComboBoxModel(ArrayList<GenericType> list) {
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement(" ");
        
        Iterator<GenericType> iterator = list.iterator();
        
        while (iterator.hasNext()) {
            GenericType next = iterator.next();
            
            model.addElement(next.getGenericTypeName());
        }
        
        return model;
    }
}
