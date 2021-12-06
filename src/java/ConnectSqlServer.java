
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static model.ConnectToDatabase.getConnect;
import model.DatabaseConnection;
import model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chuan
 */
public class ConnectSqlServer {
    private static ConnectSqlServer instance;
    private Connection connection;
    private String url="jdbc:sqlserver://localhost:1433;"
                        + "database=Webdientu;"
                        + "user=webbanhang;"
                        + "password=123456789;";
    private String user="webbanhang";
    private String password="123456789";
    private ConnectSqlServer() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }
    public static ConnectSqlServer getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectSqlServer();
        } else if (instance.getConnection().isClosed()) {
            instance = new ConnectSqlServer();
        }
        return instance;
    }
    public static void main(String[] args) throws SQLException, Exception {
        
        Connection connection = ConnectSqlServer.getInstance().getConnection();
        String sql = "SELECT * FROM EMPLOYEE";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                
                System.out.println(result.getString("Dno") + " " +result.getString("Salary"));
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
