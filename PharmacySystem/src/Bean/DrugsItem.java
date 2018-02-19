/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author Chazool
 */
@Entity
@Table
public class DrugsItem extends Drugs {

   @]
    private String ItemNo;
    private String ItemName;

    private float ItemResalePrice;

    public String getItemNo() {
        return ItemNo;
    }

    public void setItemNo(String ItemNo) {
        this.ItemNo = ItemNo;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public float getItemResalePrice() {
        return ItemResalePrice;
    }

    public void setItemResalePrice(float ItemResalePrice) {
        this.ItemResalePrice = ItemResalePrice;
    }

   

}
