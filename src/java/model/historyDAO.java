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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author memft
 */
public class historyDAO {
    public boolean InsertHistory(String type, String time, String des) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();
        
//        st.executeUpdate("INSERT INTO users (first_name, last_name, is_admin, num_points) "
//          +"VALUES ('Fred', 'Flinstone', false, 10000)");
        try{
        String sql = "INSERT INTO history (histype, hisdes, histime) VALUES(?,?,?) " ;
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, type);
        statement.setString(2, des);
        statement.setString(3, time);
        
     
        
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
    public List<History> AllListHistory() throws SQLException,
            ClassNotFoundException {
        List<History> listHistory = new ArrayList<History>();
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String sql = "SELECT * FROM history";
        History oneHistory = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int hisid = rs.getInt(1);
                String histime = rs.getString(2);
                String histype = rs.getString(3);
                String hisdes = rs.getString(4);
               
//                oneHistory = new History();
//                oneHistory.setIdhis(hisid);
//                oneHistory.setTypehis(histype);
//                oneHistory.setTimehis(histime);
//                oneHistory.setDeshis(hisdes);
//              
                oneHistory = new History.Builder()
                        .withId(hisid)
                        .withType(histype)
                        .withTime(histime)
                        .withDes(hisdes)
                        .build();
             listHistory.add(oneHistory);
            }
            connection.close();
            return listHistory;
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            connection.close();
            return null;
        }
        
    }
}
