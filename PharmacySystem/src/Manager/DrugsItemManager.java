/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.DrugsItem;
import java.util.logging.Level;
import java.util.logging.Logger;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;
import newException.nullDrugIDException;
import newException.nullDrugNameException;
import newException.nullItemIdException;
import newException.nullItemNameException;
import newException.nullResalpriceException;

/**
 *
 * @author Chazool
 */
public class DrugsItemManager extends CreateDataManager {

    private void CreateData(DrugsItem item) {
        item.setCreateUser("Chazool");
        item.setCreateDate();
        item.setCreateTime();
    }

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
    private void Check(DrugsItem item) throws nullItemNameException, nullCreateUserException, nullCreateDateException, nullCreateTimeException, nullDrugIDException, nullResalpriceException, nullItemIdException {


        if (item.getItemName() == null || item.getItemName().equals("")) {
            throw new nullItemNameException();
        }

        CheckUpdate(item);

    }

    private void CheckUpdate(DrugsItem item) throws nullItemIdException, nullResalpriceException, nullCreateUserException, nullCreateDateException, nullCreateTimeException {

        if (item.getItemNo() == null || item.getItemNo().equals("") || item.getItemNo().equals(" ")) {
            throw new nullItemIdException();
        }

        if (item.getItemResalePrice() == 0) {
            throw new nullResalpriceException();
        }

        // Check Create Data
        checkCreateData(item);

    }

    /**
     * Save Drugs Item
     *
     * @param item
     * @return String ExceptionMassage
     */
    public String Save(DrugsItem item) {

        String ExceptionMassage = "";

        try {
            //Set Create Data
            CreateData(item);
            //Check Item Data
            Check(item);

        } catch (nullItemNameException ex) {
            ExceptionMassage = "Invalid Item Name";
        } catch (nullCreateUserException ex) {
            ExceptionMassage = "Missing Create User";
        } catch (nullCreateDateException ex) {
            ExceptionMassage = "Missing Create Date";
        } catch (nullCreateTimeException ex) {
            ExceptionMassage = "Missing Create Time";
        } catch (nullDrugIDException ex) {
            ExceptionMassage = "Invalid Drugs Name";
        } catch (nullResalpriceException ex) {
            ExceptionMassage = "Invalid Resale Price";
        } catch (nullItemIdException ex) {
            ExceptionMassage = "Invalid ID";
        }
        return ExceptionMassage;
    }

    /**
     * Update Drugs Item
     *
     * @param item
     * @return String ExceptionMassage
     */
    public String UpdateAll(DrugsItem item) {

        String ExceptionMassage = "";

        try {
            //Set Create Data
            CreateData(item);
            //Check Item Data
            Check(item);
            CheckUpdate(item);

        } catch (nullItemNameException ex) {
            ExceptionMassage = "Invalid Item Name";
        } catch (nullCreateUserException ex) {
            ExceptionMassage = "Missing Create User";
        } catch (nullCreateDateException ex) {
            ExceptionMassage = "Missing Create Date";
        } catch (nullCreateTimeException ex) {
            ExceptionMassage = "Missing Create Time";
        } catch (nullDrugIDException ex) {
            ExceptionMassage = "Invalid Drugs Name";
        } catch (nullResalpriceException ex) {
            ExceptionMassage = "Invalid Resale Price";
        } catch (nullItemIdException ex) {
            ExceptionMassage = "Invalid ID";
        }
        return ExceptionMassage;
    }

    /**
     * Update Resale Price Drugs Item
     *
     * @param item
     * @return String ExceptionMassage
     */
    public String UpdateResalePrice(DrugsItem item) {

        String ExceptionMassage = "";

        try {
            // Set Create Data
            CreateData(item);
            // Check Update Resale Price Item Data
            CheckUpdate(item);

        } catch (nullCreateUserException ex) {
            ExceptionMassage = "Missing Create User";
        } catch (nullCreateDateException ex) {
            ExceptionMassage = "Missing Create Date";
        } catch (nullCreateTimeException ex) {
            ExceptionMassage = "Missing Create Time";
        } catch (nullResalpriceException ex) {
            ExceptionMassage = "Invalid Resale Price";
        } catch (nullItemIdException ex) {
            ExceptionMassage = "Invalid ID";
        }
        return ExceptionMassage;
    }

}
