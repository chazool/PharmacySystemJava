/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 *
 * @author Chazool
 *
 */
@Entity
@Table
public class Drugs extends CreateData {

    @Id
    @GeneratedValue
    private long DrugsId;
    private String DrugsName;

    public long getDrugsId() {
        return DrugsId;
    }

    public void setDrugsId(long DrugsId) {
        this.DrugsId = DrugsId;
    }

    public String getDrugsName() {
        return DrugsName;
    }

    public void setDrugsName(String DrugsName) {
        this.DrugsName = DrugsName;
    }

}
