/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.*;
/**
 *
 * @author memft
 */
public class ConnectToDatabase {
    public ConnectToDatabase(){
        
        
    }
    
    public static Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/demo";
            String user="root";
            String password="280700";
            connection=DriverManager.getConnection(url, user, password);
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error");
            
        }
        return connection;
    }
    
    public static void main(String[] args) {
        System.out.println(getConnect());
        try{
        ResultSet rs = new ConnectToDatabase().selectData("select * from users");
        
        while (rs.next()) {
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
//            String taikhoan = rs.getString(2);
//            String matkhau = rs.getString(7);
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void excuteSql (String sql) throws Exception{
        Connection connect = getConnect();
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(sql);
    }
    
    public ResultSet selectData(String sql) throws Exception{
        Connection connect = getConnect();
        Statement stmt = connect.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
    
    
}
