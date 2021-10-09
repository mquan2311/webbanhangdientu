/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author memft
 */
//public class History {
//    int idhis;
//    String deshis;
//    String typehis;
//    String timehis;
//
//    public History()
//    {
//        
//    }
//    public int getIdhis() {
//        return idhis;
//    }
//
//    public void setIdhis(int idhis) {
//        this.idhis = idhis;
//    }
//
//    public String getDeshis() {
//        return deshis;
//    }
//
//    public void setDeshis(String deshis) {
//        this.deshis = deshis;
//    }
//
//    public String getTypehis() {
//        return typehis;
//    }
//
//    public void setTypehis(String typehis) {
//        this.typehis = typehis;
//    }
//
//    public String getTimehis() {
//        return timehis;
//    }
//
//    public void setTimehis(String timehis) {
//        this.timehis = timehis;
//    }
//
//    public History(int idhis, String deshis, String typehis, String timehis) {
//        this.idhis = idhis;
//        this.deshis = deshis;
//        this.typehis = typehis;
//        this.timehis = timehis;
//    }
//    
//}
// Code for Builder Pattern //
public class History {
    
    public static class Builder{
        private int idhis;
        private String deshis;
        private String typehis;
        private String timehis;

        public Builder withId(int idhis) {
            this.idhis = idhis;
            return this;
        }

        public Builder withDes(String deshis) {
            this.deshis = deshis;
            return this;
        }

        public Builder withType (String typehis){
            this.typehis = typehis;
            return this;
        }

        public Builder withTime (String timehis){
            this.timehis = timehis;
            return this;
        }
        public History build() {
            History history = new History();
            history.idhis = this.idhis;
            history.deshis = this.deshis;
            history.typehis = this.typehis;
            history.timehis = this.timehis;
            
            return history;
        }
    }
    
    private History()
    {
    }
    private int idhis;
    private String deshis;
    private String typehis;
    private String timehis;
    public int getIdhis() {
        return idhis;
    }

    public void setIdhis(int idhis) {
        this.idhis = idhis;
    }

    public String getDeshis() {
        return deshis;
    }

    public void setDeshis(String deshis) {
        this.deshis = deshis;
    }

    public String getTypehis() {
        return typehis;
    }

    public void setTypehis(String typehis) {
        this.typehis = typehis;
    }

    public String getTimehis() {
        return timehis;
    }

    public void setTimehis(String timehis) {
        this.timehis = timehis;
    }
}
