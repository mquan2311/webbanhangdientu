/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author memft
 */
public class ProductDAO {

    public List<Product> AllListProduct() throws SQLException,
            ClassNotFoundException {
        List<Product> listProduct = new ArrayList<Product>();
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();;

        String sql = "SELECT * FROM products";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String itemid = rs.getString(1);
                String itemname = rs.getString(2);
                int itemstock = rs.getInt(3);
                float itemprice = rs.getFloat(4);
                String itemimg = rs.getString(5);
                String itemdes = rs.getString(6);
                Product oneProduct = new Product();
                oneProduct.setItemId(itemid);
                oneProduct.setItemName(itemname);
                oneProduct.setItemStock(itemstock);
                oneProduct.setItemPrice(itemprice);
                oneProduct.setItemImg(itemimg);
                oneProduct.setItemDes(itemdes);
                listProduct.add(oneProduct);
            }
            connection.close();
            return listProduct;
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            connection.close();
            return null;
        }
        
    }

    public Product getItemInfo(String itemid) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String sql = "SELECT * FROM products WHERE itemid = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemid);

        ResultSet result = statement.executeQuery();

        Product product = null;

        if (result.next()) {
            product = new Product();
//            user.setUserName(result.getString("username"));
//            user.setEmail(username);
            product.setItemId(itemid);
            product.setItemName(result.getString("itemname"));
            product.setItemStock(result.getInt("itemstock"));
            product.setItemPrice(result.getFloat("itemprice"));
            product.setItemImg(result.getString("itemimg"));
            product.setItemDes(result.getString("itemdes"));

        }

        connection.close();

        return product;
    }

    public static boolean delProfile(String itemid) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        try {

            String sql = "DELETE FROM products WHERE itemid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, itemid);
            statement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException e) {
            connection.close();
            return false;
        }

    }

    public static boolean delQuantity(String itemid, int itemstock) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String sql = "UPDATE products SET itemstock = ? WHERE itemid = ?";
        
        
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, itemstock);
                statement.setString(2, itemid);
                statement.executeUpdate();
                connection.close();
                return true;
            } catch (SQLException e) {
                connection.close();
                return false;
            }
        }

    
}
