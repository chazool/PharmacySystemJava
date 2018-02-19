/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Chazool
 */
@Entity
@Table
public class User extends CreateData {

    @Id
    private String UserName;
    private String EmployeeName;
    private String EmployeeNIC;
    private String Password;
    private String RetypePassword;
    private String UserRole;

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public String getEmployeeNIC() {
        return EmployeeNIC;
    }

    public void setEmployeeNIC(String EmployeeNIC) {
        this.EmployeeNIC = EmployeeNIC;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRetypePassword() {
        return RetypePassword;
    }

    public void setRetypePassword(String RetypePassword) {
        this.RetypePassword = RetypePassword;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }

}
