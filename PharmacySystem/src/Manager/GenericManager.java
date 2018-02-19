/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Generic;
import Bean.Message;
import DAO.DBGeneric;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import newException.nullCategoryException;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;
import newException.nullDrugNameException;

/**
 *
 * @author Chazool
 */
public class GenericManager extends CreateDataManager {

    private DBGeneric db = new DBGeneric();

    /**
     * check Generic data and Create Data
     *
     * @param drugs
     * @throws nullDrugNameException
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     *
     */
    protected boolean checkGeneric(Generic generic) throws nullDrugNameException, nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullCategoryException {

        Boolean bool = true;

        //Check Generic Name
        if (generic.getGenericName().equals("") || generic.getGenericName() == null || generic.getGenericName().equals(" ")) {
            bool = false;
            throw new nullDrugNameException();
        }

        if (generic.getCategory().equals("") || generic.getCategory() == null || generic.getCategory().equals(" ")) {
            bool = false;
            throw new nullCategoryException();
        }
        // Checking Create Data and Throws Exceptions 
        checkCreateData(generic);

        return bool;
    }

    /**
     * Check and Save Generic Data
     *
     * @param generic
     * @return String ExceptionMassage
     */
    public String SaveorUpdate(Generic generic) throws nullDrugNameException, nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullCategoryException {

        DefaultTableModel model = null;
        String Massage = "";

        // Set Create Data
        setCreteData(generic);

        //Check Drugs Data
        if (checkGeneric(generic)) {
            if (MessageManager.YesOrNoMessage("Are You Sure", "Generic Save") == 0) {
                db.SaveorUpdate(generic);
            }

        }

        // Save to Database
        return Massage;
    }

    /**
     * Update Drugs Data
     *
     * @param drugs
     * @return String ExceptionMassage
     */
    public String Update(Generic Generic) {
        String ExceptionMassage = "";
        try {
            // Set Create Data
            Generic.setCreateUser("Set Create User");
            Generic.setCreateDate();
            Generic.setCreateTime();
            // ************************
            //Check Drugs Data
            checkGeneric(Generic);

        } catch (nullDrugNameException ex) {
            ExceptionMassage = "Invalid Drug Name ";
        } catch (nullCreateUserException ex) {
            ExceptionMassage = "Missing C reate User";
        } catch (nullCreateDateException ex) {
            ExceptionMassage = "Missing Create Date";
        } catch (nullCreateTimeException ex) {
            ExceptionMassage = "Missing Create Time";
        } catch (nullCategoryException ex) {
            ExceptionMassage = "Invalid Category";
        }

        return ExceptionMassage;
    }

    public void Delete(String DrugsId) {

    }

    /**
     * Select All Drugs Data
     *
     * @return
     */
    public static DefaultTableModel Select() {

        ArrayList<Generic> list = DBGeneric.Select();
        DefaultTableModel model = getModel(list);

        return model;
    }

    /**
     * get DefaultTableModel
     *
     * @param list
     * @return
     */
    private static DefaultTableModel getModel(ArrayList<Generic> list) {
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{" ", "Generic Name", "Category"});

        Iterator<Generic> iterator = list.iterator();
        int no = 0;
        while (iterator.hasNext()) {
            Generic next = iterator.next();
            model.addRow(new Object[]{++no, next.getGenericName(), next.getCategory()});
        }

        return model;
    }

    public static DefaultTableModel SelectKeyType(String Text) {

        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"", "Generic Name", "Category"});

        ArrayList<Generic> list = DBGeneric.SelectKeyType(Text);

        Iterator<Generic> iterator = list.iterator();

        Object row[] = new Object[3];
        int no = 0;

        while (iterator.hasNext()) {
            Generic next = iterator.next();
            row[0] = ++no;
            row[1] = next.getGenericName();
            row[2] = next.getCategory();

            model.addRow(row);

        }

        return model;
    }

}
