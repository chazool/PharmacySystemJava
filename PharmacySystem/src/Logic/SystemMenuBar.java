/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import GUI.GUIAddGeneric;
import GUI.GUIAddItem;
import GUI.GUIHome;
import GUI.GUIAddStock;
import GUI.GUIUserLogin;
import GUI.GUIUserRegistration;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Chazool
 */
public class SystemMenuBar {

    private JFrame frame;

    public SystemMenuBar(JFrame frame) {
        this.frame = frame;
    }

    /**
     * Go To Home Page
     */
    public void ShowHomePage() {
        GUIHome home = new GUIHome();
        home.setVisible(true);
        home.setExtendedState(frame.getExtendedState());
        frame.dispose();
    }

    /*
     Go Drugs Adding Page
     */
    public void ShowAddingDrugs() {
        GUIAddGeneric AddDrugs = new GUIAddGeneric();
        AddDrugs.setVisible(true);
        AddDrugs.setExtendedState(frame.getExtendedState());

        this.frame.dispose();
    }

    /*
     Go Drugs Item Adding Page
     */
    public void ShowAddingDrugsItem() {
        GUIAddItem AddDrugsItem = new GUIAddItem();
        AddDrugsItem.setVisible(true);
        AddDrugsItem.setExtendedState(frame.getExtendedState());
        frame.dispose();
    }

    /**
     * Go Adding Stock Drugs Page
     */
    public void ShowAddingStockDrugs() {
        GUIAddStock StockDrugsItem = new GUIAddStock();
        StockDrugsItem.setVisible(true);
        StockDrugsItem.setExtendedState(frame.getExtendedState());
        frame.dispose();
    }

    /**
     * Go Update Drugs Data Page
     */
    public void ShowUpdateDrugs() {
        frame.dispose();
    }

    /**
     * Go Update Drugs Item Data Page
     */
    public void ShowUpdateDrugsItem() {
        frame.dispose();
    }

    /**
     * Go update Drugs
     */
    public void ShowUpdateStockDrugs() {
        frame.dispose();
    }

    /*
     System LogOut
     */
    public void LogOut() {

        int no = JOptionPane.showConfirmDialog(null, "Are You Sure", "Confirm Details ", JOptionPane.YES_NO_OPTION);

        if (no == 0) {
            GUIUserLogin UserLogin = new GUIUserLogin();
            UserLogin.setVisible(true);
            UserLogin.setExtendedState(frame.getExtendedState());
            frame.dispose();
        }

    }

    /**
     * Go User Registration Page
     */
    public void ShowUserAdding() {
        GUIUserRegistration UserReg = new GUIUserRegistration();
        UserReg.setVisible(true);
        UserReg.setExtendedState(frame.getExtendedState());
        frame.dispose();
    }

    public void ShowDeleteDrugs() {
        frame.dispose();
    }

    public void ShowDeleteDrugsItem() {
        frame.dispose();
    }

    public void ShowDeleteStockDrugs() {
        frame.dispose();
    }

    /**
     * Show User Data Update Page
     */
    public void ShowUserUpdate() {
        frame.dispose();
    }

    /**
     * Show User Data Delete Page
     */
    public void ShowUserDelete() {
        frame.dispose();
    }

}
