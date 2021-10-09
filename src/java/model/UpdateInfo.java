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
public class UpdateInfo {

    public boolean UpdateInfomation(String userusername, String username, String showname, String address, String email, String phone, String city, String country, int level) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
//        String dbUser = "root";
//        String dbPassword = "280700";
//
//        Class.forName("com.mysql.jdbc.Driver");
//
//        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
//        

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "UPDATE users SET showname = ? , address = ? , email = ? , phone = ? , city = ? , country = ? , username = ?, level = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, showname);
            statement.setString(2, address);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, city);
            statement.setString(6, country);
            statement.setString(7, username);
            statement.setInt(8, level);
            statement.setString(9, userusername);

            statement.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public User Up(String username) throws SQLException,
            ClassNotFoundException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        String sql = "SELECT * FROM users WHERE username = ?";
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
            user.setAddress(result.getString("address"));
            user.setShowName(result.getString("showname"));
            user.setPhone(result.getString("phone"));
            user.setCity(result.getString("city"));
            user.setCountry(result.getString("country"));
            user.setLevel(result.getInt("level"));
            user.setPassword(result.getString("password"));
        }

        connection.close();

        return user;
    }

    public boolean UpdateItemInfomation(String itemid, String itemidold, String itemname, String itemdes, String itemimg, float itemprice, int itemstock) throws SQLException,
            ClassNotFoundException {
////        String jdbcURL = "jdbc:mysql://localhost:3306/demo";

        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "UPDATE products SET itemid = ? , itemname = ? , itemdes = ? , itemimg = ? , itemprice = ? , itemstock = ? WHERE itemid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, itemid);
            statement.setString(2, itemname);
            statement.setString(3, itemdes);
            statement.setString(4, itemimg);
            statement.setFloat(5, itemprice);
            statement.setInt(6, itemstock);
            statement.setString(7, itemidold);

            statement.executeUpdate();
            
            connection.close();
            
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
      

    }
}
