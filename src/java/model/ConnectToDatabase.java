/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.PreparedStatement;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
/**
 *
 * @author memft
 */
public class ConnectToDatabase {
   
    public ConnectToDatabase(){
        
        
    }
    
    public static Connection getConnect() {
        //Connection  connection = null;
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;"
                        + "database=Webdientu;"
                        + "user=webbanhang;"
                        + "password=123456789;";
                       
        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
            System.out.println("OK 1");
               return connection;
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
       
      
            
        
       
        
    }
    
    public static void main(String[] args) throws SQLException, Exception {
        
                  
        ResultSet resultSet = null;
        Connection  connection = getConnect();   
        String selectSql = "SELECT * FROM EMPLOYEE";
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery(selectSql);   
        while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " );
            }
//        
//        try (Connection connection = DriverManager.getConnection(connectionUrl);
//                Statement statement = connection.createStatement();){
//            // Code here.
//            System.out.println("OK 1");
//           
//
//            // Create and execute a SELECT SQL statement.
//            String selectSql = "SELECT * FROM EMPLOYEE";
//            resultSet = statement.executeQuery(selectSql);
//
//            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2) + " " );
//            }
//        }
//        // Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
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
