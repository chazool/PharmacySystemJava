/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.CreateData;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;

/**
 *
 * @author Chazool
 */
public class CreateDataManager {

    /**
     * Checking Create Data
     *
     * @param createData
     * @throws nullCreateUserException
     * @throws nullCreateDateException
     * @throws nullCreateTimeException
     */
    protected static boolean checkCreateData(CreateData createData) throws nullCreateUserException, nullCreateDateException, nullCreateTimeException {

        boolean bool = true;

        if (createData.getCreateUser() == null || createData.getCreateUser().equals("")) {
            bool = false;
            throw new nullCreateUserException();
        }
        if (createData.getCreateDate() == null) {
            bool = false;
            throw new nullCreateDateException();
        }
        if (createData.getCreateTime() == null) {
            bool = false;
            throw new nullCreateTimeException();
        }
        return bool;
    }

    /**
     * Set Create Data
     *
     * @param createData
     */
    public static void setCreteData(CreateData createData) {

        createData.setCreateUser("Set Create User");
        createData.setCreateDate();
        createData.setCreateTime();
    }
}
