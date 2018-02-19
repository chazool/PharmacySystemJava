/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Bean.Item;
import DAO.DBOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chazool
 */
public class OrderManager {

    public static DefaultTableModel SelectKeyType(String Text) {

        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{"", "Item Name", "Generic", "Price"});

        ArrayList<Item> list = DBOrder.SelectKeyType(Text);

        Iterator<Item> iterator = list.iterator();

        Object row[] = new Object[4];
        int no = 0;
        while (iterator.hasNext()) {
            Item next = iterator.next();
            row[0] = ++no;
            row[1] = next.getItemName();
            row[2] = next.getGeneric();
            row[3] = "0";
            model.addRow(row);
        }

        return model;
    }

    

}
