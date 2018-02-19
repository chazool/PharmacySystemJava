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
public class StockBatch extends CreateData implements Serializable {

    @Id
    private String ItemName;
    private String EXPDate;
    @Id
    private String Batch;
    @Id
    private float CostPrice;
    private int Quantity;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getEXPDate() {
        return EXPDate;
    }

    public void setEXPDate(String EXPDate) {
        this.EXPDate = EXPDate;
    }

    public String getBatch() {
        return Batch;
    }

    public void setBatch(String Batch) {
        this.Batch = Batch;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(float CostPrice) {
        this.CostPrice = CostPrice;
    }

}
