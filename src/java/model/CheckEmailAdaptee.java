/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chuan
 */
public class CheckEmailAdaptee {
    public boolean checkEmail(String para){
        Pattern parapattern = Pattern.compile("\\w+@\\w+(.\\w+)*");
        Matcher paramatcher = parapattern.matcher(para);
        if (paramatcher.matches()) {
            return true;
        } else {
            return false;
        }
        
    }
    public boolean checkNumber(String para){
    
        Pattern parapattern = Pattern.compile("\\d+");
        Matcher paramatcher = parapattern.matcher(para);
        if (paramatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isWord(String para) {
        Pattern parapattern = Pattern.compile("\\w+");
        Matcher paramatcher = parapattern.matcher(para);
        if (paramatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
