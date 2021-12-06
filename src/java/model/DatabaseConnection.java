/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author chuan
 */
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String url="jdbc:sqlserver://localhost:1433;databaseName=Webdientu";
    private String user="webbanhang1";
    private String password="qweasdzxc";

    private DatabaseConnection() throws SQLException {
        try {
            System.out.println("1");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("2");
            this.connection = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public static void main(String[] args) throws SQLException, Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
    }
    
}
