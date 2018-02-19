/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Bean.Generic;
import newException.nullDrugIDException;

/**
 *
 * @author Chazool
 */
public class Test extends Generic{

    public static void CheckDrugs(Generic drugs) throws nullDrugIDException {
        
//        if (drugs.getDrugsId() == null || drugs.getDrugsId().equals("")) {
//            throw new nullDrugIDException();
//        } else {
//            
//            
//            System.out.println(drugs.getDrugsId());
//            System.out.println(drugs.getDrugsName());
//            System.out.println(drugs.getCreateUser());
//            System.out.println(drugs.getCreateDate());
//            System.out.println(drugs.getCreateTime());
//
//        }
        
       

    }

    public static void main(String[] args) {

        int x = 0;
        float y = 0.0f;
        if (x==y) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

    }

}
