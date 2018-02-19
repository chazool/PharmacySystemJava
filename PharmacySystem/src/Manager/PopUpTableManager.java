/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Stock;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chazool
 */
public class PopUpTableManager {

    public static DefaultTableModel SetBarcode(ArrayList<Stock> list) {

        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"", "Item", "Resale Price"});

        Object row[] = new Object[3];
        // Set Table
        Iterator<Stock> iterator = list.iterator();

        while (iterator.hasNext()) {
            Stock next = iterator.next();
            row[0] = "";
            row[1] = next.getItemName();
            row[2] = next.getResalePrice();
            model.addRow(row);
        }

        return model;
    }

}
