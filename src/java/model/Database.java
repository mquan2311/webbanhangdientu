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
class Database {
    private static Database db;
    private Database(){}
    public static Database getInstance(){
        if (db==null){
            db= new Database();
        }
        return db;
    }
    public void getConnection(){
        System.out.print("OK");
    }
}
class main{
    public static void main(String[] args) {
      Database db;

      // refers to the only object of Database
      db= Database.getInstance();
      
      db.getConnection();
   }
}
