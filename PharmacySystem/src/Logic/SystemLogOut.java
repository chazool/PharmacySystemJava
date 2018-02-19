/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import GUI.GUIUserLogin;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Chazool
 */
public class SystemLogOut {

    public SystemLogOut(JFrame frame) {

        int no = JOptionPane.showConfirmDialog(null, "Are You Sure", "Confirm Details ", JOptionPane.YES_NO_OPTION);

        if (no == 0) {
            new GUIUserLogin().setVisible(true);
            frame.dispose();
        }

    }

}
