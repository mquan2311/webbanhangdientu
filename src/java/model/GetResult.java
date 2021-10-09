/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author memft
 */
public class GetResult {
    public User Get(String username, String para) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
//        String dbUser = "root";
//        String dbPassword = "123456789";
// 
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        
        Connection connection = new ConnectToDatabase().getConnect();
        
        
        String sql = "SELECT * FROM users WHERE username = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
            user = new User();
//            user.setUserName(result.getString("username"));
//            user.setEmail(username);
              user.setUserName(username);
              user.setEmail(result.getString("email"));
        }
 
        connection.close();
 
        return user;
    }
    
    
}
