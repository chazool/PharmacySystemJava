/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import javax.swing.JOptionPane;

/**
 *
 * @author Chazool
 */
public class MessageManager {

    public static void SaveMessage(String SetMessage, String SetTitle) {
        JOptionPane.showMessageDialog(null, SetMessage, SetTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int YesOrNoMessage(String SetMessage, String SetTitle) {

        int value = JOptionPane.showConfirmDialog(null, "Are You Sure", "Confirm Details ", JOptionPane.YES_NO_OPTION);

        return value;
    }

}
