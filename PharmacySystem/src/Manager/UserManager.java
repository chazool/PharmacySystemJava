/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.User;
import DAO.DBUser;
import GUI.GUIHome;
import Logic.SystemLogOut;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import newException.InvalidPasswordException;
import newException.PasswordLengthException;
import newException.UnMatchingPasswordException;
import newException.nullCreateDateException;
import newException.nullCreateTimeException;
import newException.nullCreateUserException;
import newException.nullEmployeeNameException;
import newException.nullNICException;
import newException.nullUserNameException;
import newException.nullUserRoleException;

/**
 *
 * @author Chazool
 */
public class UserManager extends CreateDataManager {

    private DBUser db = new DBUser();

    //LogOut
    public void LogOut(JFrame frame) {
        new SystemLogOut(frame);
    }

    private boolean checkUser(User user) throws nullEmployeeNameException, nullNICException, nullUserNameException, PasswordLengthException, UnMatchingPasswordException, nullUserRoleException, nullCreateUserException, nullCreateDateException, nullCreateTimeException {
        boolean bool = true;

        if (user.getEmployeeName().length() <= 3) {
            bool = false;
            throw new nullEmployeeNameException();
        }

        if (user.getEmployeeNIC().length() < 10) {
            bool = false;
            throw new nullNICException();
        }

        if (user.getUserName().equals("") || user.getUserName().length() <= 3) {
            bool = false;
            throw new nullUserNameException();
        }

        if (user.getPassword().length() < 5) {
            bool = false;
            throw new PasswordLengthException();

        } else if ((!user.getPassword().equals(user.getRetypePassword())) || user.getRetypePassword() == null || user.getRetypePassword().equals("")) {
            System.out.println(user.getPassword());
            System.out.println(user.getRetypePassword());

            bool = false;
            throw new UnMatchingPasswordException();
        }

        if (user.getUserRole().equals(" ") || user.getUserRole().equals("")) {
            bool = false;
            throw new nullUserRoleException();
        }

        // Check Create Data
        checkCreateData(user);

        return bool;
    }

    /**
     * Get User Data And set Create Data , Save User Data
     *
     * @param user
     * @return String ExceptionMassage
     */
    public String Save(User user) {

        String ExceptionMassage = "";

        try {
            //Set Create Data
            setCreteData(user);

            //Checking User
            checkUser(user);

            //Save User            
            db.Save(user);

        } catch (nullEmployeeNameException ex) {
            ExceptionMassage = "Invalid Employee Name";
        } catch (nullNICException ex) {
            ExceptionMassage = "Invalid Employee NIC";
        } catch (nullUserNameException ex) {
            ExceptionMassage = "Invalid User Name";
        } catch (PasswordLengthException ex) {
            ExceptionMassage = "Low Password Length";
        } catch (UnMatchingPasswordException ex) {
            ExceptionMassage = "Retype Password are Unmatching";
        } catch (nullUserRoleException ex) {
            ExceptionMassage = "Invalid User Role";
        } catch (nullCreateUserException ex) {
            ExceptionMassage = "Missing Create User";
        } catch (nullCreateDateException ex) {
            ExceptionMassage = "Missing Create Date";
        } catch (nullCreateTimeException ex) {
            ExceptionMassage = "Missing Create Time";
        }

        return ExceptionMassage;
    }

    private void CheckLogin(User user) throws InvalidPasswordException {
        user.getUserName();

        String password = "";

        if (!user.getPassword().equals(password)) {
            throw new InvalidPasswordException();
        }

    }

    public static String Login(User user, JFrame frame, JProgressBar bar) throws InvalidPasswordException, NullPointerException {
        String ExceptionMassage = "";

        // Go Home Page
        String Password = DBUser.Select(user.getUserName().trim(), bar);

        if (Password.equals(user.getPassword())) {

            new GUIHome().setVisible(true);
            bar.setValue(100);
            frame.dispose();
        } else {
            throw new InvalidPasswordException();
        }

        return ExceptionMassage;
    }
}
