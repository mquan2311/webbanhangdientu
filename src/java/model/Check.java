/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;

/**
 *
 * @author memft
 */



public class Check {

    public static boolean isEqual(String para1, String para2) {
        if (para1.equals(para2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isWord(String para) {
        Pattern parapattern = Pattern.compile("\\w+");
        Matcher paramatcher = parapattern.matcher(para);
        if (paramatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFloat(String para) {
        try {
            Float.parseFloat(para);
            return true;
        } catch (NumberFormatException e) {
            //not float
            return false;

        }
    }

    public static boolean isNumber(String para) {
        Pattern parapattern = Pattern.compile("\\d+");
        Matcher paramatcher = parapattern.matcher(para);
        if (paramatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmail(String para) {
        Pattern parapattern = Pattern.compile("\\w+@\\w+(.\\w+)*");
        Matcher paramatcher = parapattern.matcher(para);
        if (paramatcher.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isExistusername(String para) throws SQLException,
            ClassNotFoundException {

//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, para);

            ResultSet rs = statement.executeQuery();
            User user = null;

            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("username"));
                String exist = user.getUserName();
                if (exist != null) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return true;
    }

    public static boolean isExistemail(String para) throws SQLException,
            ClassNotFoundException {

//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, para);

            ResultSet rs = statement.executeQuery();
            User user = null;

            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("email"));
                String exist = user.getUserName();
                if (exist != null) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return true;
    }

    public static boolean isExistphone(String para) throws SQLException,
            ClassNotFoundException {

//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM users WHERE phone = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, para);

            ResultSet rs = statement.executeQuery();
            User user = null;

            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("phone"));
                String exist = user.getUserName();
                if (exist != null) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return true;
    }

    public static boolean isExistItemId(String para) throws SQLException,
            ClassNotFoundException {

//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM products WHERE itemid = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, para);

            ResultSet rs = statement.executeQuery();
            Product product = null;

            if (rs.next()) {
                product = new Product();
                product.setItemId(rs.getString("itemid"));
                String exist = product.getItemId();
                if (exist != null) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return true;
    }
    public static int randInt(int min, int max) {

    // NOTE: This will (intentionally) not run as written so that folks
    // copy-pasting have to think about how to initialize their
    // Random instance.  Initialization of the Random instance is outside
    // the main scope of the question, but some decent options are to have
    // a field that is initialized once and then re-used as needed or to
    // use ThreadLocalRandom (if using at least Java 1.7).
    // 
    // In particular, do NOT do 'Random rand = new Random()' here or you
    // will get not very good / not very random results.
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}

    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
//        String dbUser = "root";
//        String dbPassword = "123456789";
//        String para1 = "username";
//        String para2 = "admin";
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
//        try {
//            String sql = "SELECT * FROM users WHERE username = ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, para2);
////        statement.setString(2, para2);
//
//            ResultSet rs = statement.executeQuery();
//            User user = null;
//
//            if (rs.next()) {
//                user = new User();
//                user.setUserName(rs.getString("username"));
//                String exist = user.getUserName();
//                if (exist != null) {
//                    System.out.println("Error1");
//                    System.out.println(exist);
//                } else {
//                    System.out.println(exist);
//                }
//
//            } else {
//                System.out.println("Khong ton tai - true");
//
//            }
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }
//        System.out.println("Error3");
        String test = "Alo 123 : $848.123";
        char c ;
        char z = '$';
      
        int dem = 0;
        for (int i = test.length()-1 ; i>0; i--){
                c = test.charAt(i);
                
                if (Character.compare(z,c)==0) {dem = i; break;}
                
            }
        String test2 = test.substring(dem+1,test.length());
        System.out.println(test2);
        System.out.println(test.charAt(6));
        if (Check.isFloat(test2)) {  
            float num = Float.parseFloat(test2);
            num = num + 100;
        System.out.println(num);
        
        }
    }
}
