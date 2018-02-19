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
 *
 */
@Entity
@Table
public class Generic extends CreateData implements Serializable {

    @Id
    private String GenericName;
    private String Category;

    public String getGenericName() {
        return GenericName;
    }

    public void setGenericName(String GenericName) {
        this.GenericName = GenericName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

}
