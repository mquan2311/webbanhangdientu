
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Check;
import model.CheckEmailAdaptee;
import model.CheckTarget;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chuan
 */
public class Adapter implements CheckTarget {
//    CheckEmailAdaptee checkEmailAdaptee = new CheckEmailAdaptee();
//    
//    public boolean verifyEmail (String para){
//    
//        if(!checkEmailAdaptee.checkEmail(para)){
//            return false;
//        }
//        return true;
//    }
//    public boolean verifyNumber (String para){
//    
//        if(!checkEmailAdaptee.checkNumber(para)){
//            return false;
//        }
//        return true;
//    }
    Check check = new Check();
    public boolean verifyEmail (String para){
    
        if(!check.isEmail(para)){
            return false;
        }
        return true;
    }
    public boolean verifyNumber (String para){
    
        if(!check.isNumber(para)){
            return false;
        }
        return true;
    }
    public boolean verifyWord (String para){
    
        if(!check.isWord(para)){
            return false;
        }
        return true;
    }
    public boolean verifyFloat (String para){
    
        if(!check.isFloat(para)){
            return false;
        }
        return true;
    }
    public boolean verifyEqual (String para1,String para2){
    
        if(!check.isEqual(para1,para2)){
            return false;
        }
        return true;
    }
    public boolean verifyExistusername (String para){
    
        try {
            if(!check.isExistusername(para)){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean verifyExistphone (String para) {
    
        try {
            if(!check.isExistphone(para)){
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean verifyExistemail (String para){
    
        try {
            if(!check.isExistemail(para)){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public boolean verifyExistItemId (String para){
    
        try {
            if(!check.isExistItemId(para)){
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    
}
