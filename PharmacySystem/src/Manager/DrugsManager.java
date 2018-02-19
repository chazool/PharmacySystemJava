/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Drugs;
import DAO.DBDrugs;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;
import newException.nullDrugNameException;

/**
 *
 * @author Chazool
 */
public class DrugsManager extends CreateDataManager {

    private DBDrugs db = new DBDrugs();

    /**
     * check Drugs data and Create Data
     *
     * @param drugs
     * @throws nullDrugNameException
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     *
     */
    protected void checkDrugs(Drugs drugs) throws nullDrugNameException, nullCreateUserException, nullCreateDateException, nullCreateTimeException {

        if (drugs.getDrugsName().equals("") || drugs.getDrugsName() == null) {

            throw new nullDrugNameException();
        }

        // Checking Create Data and Throws Exceptions 
        checkCreateData(drugs);

    }

    /**
     * Check and Save Drugs Data
     *
     * @param drugs
     * @return String ExceptionMassage
     */
    public String SaveorUpdate(Drugs drugs) {
        String ExceptionMassage = "";
        try {
            // Set Create Data
            drugs.setCreateUser("Set Create User");
            drugs.setCreateDate();
            drugs.setCreateTime();

            //Check Drugs Data
            checkDrugs(drugs);

            // Save to Database
            db.Save(drugs);
            
            
        } catch (nullDrugNameException ex) {
            ExceptionMassage = "Invalid Drug Name ";
        } catch (nullCreateUserException ex) {
            ExceptionMassage = "Missing C reate User";
        } catch (nullCreateDateException ex) {
            ExceptionMassage = "Missing Create Date";
        } catch (nullCreateTimeException ex) {
            ExceptionMassage = "Missing Create Time";
        }

        return ExceptionMassage;
    }

    /**
     * Update Drugs Data
     *
     * @param drugs
     * @return String ExceptionMassage
     */
    public String Update(Drugs drugs) {
        String ExceptionMassage = "";
        try {
            // Set Create Data
            drugs.setCreateUser("Set Create User");
            drugs.setCreateDate();
            drugs.setCreateTime();
            // ************************
            //Check Drugs Data
            checkDrugs(drugs);

        } catch (nullDrugNameException ex) {
            ExceptionMassage = "Invalid Drug Name ";
        } catch (nullCreateUserException ex) {
            ExceptionMassage = "Missing C reate User";
        } catch (nullCreateDateException ex) {
            ExceptionMassage = "Missing Create Date";
        } catch (nullCreateTimeException ex) {
            ExceptionMassage = "Missing Create Time";
        }

        return ExceptionMassage;
    }

    public void Delete(String DrugsId) {

    }
}
