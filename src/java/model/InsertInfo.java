/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.*;
import static model.ConnectToDatabase.getConnect;
/**
 *
 * @author memft
 */
public class InsertInfo {
    public boolean InsertInfomation(String username, String password, String showname, String address, String email, String phone, String city, String country, int level) throws SQLException,
            ClassNotFoundException {
        
        Connection connection = DatabaseConnection.getInstance().getConnection();
        
        try{
        String sql = "INSERT INTO users (username, showname, address, email, phone, password, city, country, level) VALUES(?,?,?,?,?,?,?,?,?) " ;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, showname);
        statement.setString(3, address);
        statement.setString(4, email);
        statement.setString(5, phone);
        statement.setString(6, password);
        statement.setString(7, city);
        statement.setString(8, country);
        statement.setInt(9, level);
     
        
        statement.executeUpdate();
        
        connection.close();
        return true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            connection.close();
            return false;
        }
        
     
        
    
    }
    public boolean InsertItemInfomation(String itemid, String itemname, String itemdes, String itemimg, int itemstock, float itemprice) throws SQLException,
            ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try{
        String sql = "INSERT INTO products (itemid, itemname, itemdes, itemimg, itemstock, itemprice) VALUES(?,?,?,?,?,?) " ;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemid);
        statement.setString(2, itemname);
        statement.setString(3, itemdes);
        statement.setString(4, itemimg);
        statement.setInt(5, itemstock);
        statement.setFloat(6, itemprice);

     
        
        statement.executeUpdate();
        
        connection.close();
        return true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            
            return false;
        }
        
     
        
    
    }
    public boolean ChangePW(String username, String password) throws SQLException,
            ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        
        try{
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, password);
        statement.setString(2, username);

     
        
        statement.executeUpdate();
        
        connection.close();
        return true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        
     
        
    
    }
}
