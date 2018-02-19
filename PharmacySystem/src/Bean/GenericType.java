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
public class GenericType extends CreateData implements Serializable {

    @Id
    private String GenericTypeName;
    private String Category;

    public String getGenericTypeName() {
        return GenericTypeName;
    }

    public void setGenericTypeName(String GenericTypeName) {
        this.GenericTypeName = GenericTypeName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

}
