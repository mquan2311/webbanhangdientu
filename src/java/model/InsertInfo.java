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

    public boolean InsertInfomation(String username, String password, String address, String email, int gender, String phone, int level) throws SQLException,
            ClassNotFoundException {

        Connection connection = DatabaseConnection.getInstance().getConnection();

        try {
            String sql = "EXECUTE [dbo].[InsertInfomation]  @username = ?, @password = ?, @email = ? , @phone = ? , @gender = ?, @address = ? ,  @role = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setInt(5, gender);
            statement.setString(6, address);

            statement.setInt(7, level);

            statement.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection.close();
            return false;
        }

    }

    public boolean InsertItemInfomation(String itemid, String itemname, String itemdes, String itemimg, int itemstock, float itemprice) throws SQLException,
            ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "INSERT INTO products (itemid, itemname, itemdes, itemimg, itemstock, itemprice) VALUES(?,?,?,?,?,?) ";
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
        } catch (SQLException ex) {
            ex.printStackTrace();

            return false;
        }

    }

    public boolean ChangePW(String username, String password) throws SQLException,
            ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        try {
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, username);

            statement.executeUpdate();

            connection.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) throws SQLException {

    }
}
