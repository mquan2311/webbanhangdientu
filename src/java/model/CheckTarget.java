/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author chuan
 */
public interface CheckTarget{
    boolean verifyNumber (String para);
    boolean verifyWord (String para);
    boolean verifyFloat (String para);
    boolean verifyEmail (String para);
    boolean verifyEqual (String para1,String para2);
    boolean verifyExistusername (String para);
    boolean verifyExistphone (String para);
    boolean verifyExistemail (String para);
    boolean verifyExistItemId (String para);
    
}   
//public interface CheckTarget {

    

    
//    interface NumberTarget {
//        boolean verifyNumber (String para);
//    }
//    interface WordTarget {
//        boolean verifyWord (String para);
//    }
//    interface FloatTarget {
//        boolean verifyFloat (String para);
//    }
//    interface EmailTarget {
//        boolean verifyEmail (String para);
//    }
//    interface EqualTarget {
//        boolean verifyEqual (String para1,String para2);
//    }
//    interface ExistusernameTarget {
//        boolean verifyExistusername (String para);
//    }
//    interface ExistphoneTarget {
//        boolean verifyExistphone (String para);
//    }
//    interface ExistemailTarget {
//        boolean verifyExistemail (String para);
//    }
//    interface ExistItemIdTarget {
//        boolean verifyExistItemId (String para);
//    }
//    interface randIntTarget {
//        int verifyrandInt (int min,int max);
//    }
////}



