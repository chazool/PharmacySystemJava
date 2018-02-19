/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chazool
 */
@Entity
@Table
public class Stock extends CreateData implements Serializable {

    @Id
    private String ItemName;
    @Id
    private float ResalePrice;
    private int Quantity;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public float getResalePrice() {
        return ResalePrice;
    }

    public void setResalePrice(float ResalePrice) {
        this.ResalePrice = ResalePrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }


}
