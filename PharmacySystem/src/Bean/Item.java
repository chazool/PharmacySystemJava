/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chazool
 */
@Table
@Entity
public class Item extends CreateData implements Serializable {

    @Id
    private String ItemName;
    
    private String Generic;
    private String Barcord;
    private String Type;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public String getBarcord() {
        return Barcord;
    }

    public void setBarcord(String Barcord) {
        this.Barcord = Barcord;
    }

    public String getGeneric() {
        return Generic;
    }

    public void setGeneric(String Generic) {
        this.Generic = Generic;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

}
