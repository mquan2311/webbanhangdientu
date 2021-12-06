/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

/**
 *
 * @author memft
 */
public class UserDAO {

    public User checkLogin(String username, String password) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
//        String dbUser = "root";
//        String dbPassword = "280700";
//
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
//        Connection connection = DatabaseConnection.getInstance().getConnection();

        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "EXECUTE [dbo].[checklogin]  @username = ?, @password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
            user.setAddress(result.getString("address"));
            user.setUserName(result.getString("username"));
            user.setAddress(result.getString("address"));
            user.setEmail(result.getString("email"));
            user.setPhone(result.getString("phone"));
            user.setGender(result.getInt("gender"));
            user.setRole(result.getInt("role"));
        }

        connection.close();

        return user;
    }

    public List<User> AllListUser() throws SQLException,
            ClassNotFoundException {
        List<User> listUser = new ArrayList<User>();
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String sql = "EXECUTE [dbo].[getAllUsers]  ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            User user = null;
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user = new User();
//            user.setUserName(result.getString("username"));
//            user.setEmail(username);
                user.setUserName(result.getString("username"));
                user.setEmail(result.getString("email"));
                user.setAddress(result.getString("address"));
                user.setPhone(result.getString("phone"));
                user.setGender(result.getInt("gender"));
                user.setRole(result.getInt("role"));
                listUser.add(user);
            }

            return listUser;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public User getProfile(String username) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String sql = "EXECUTE [dbo].[getProfile]  @username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
//            user.setUserName(result.getString("username"));
//            user.setEmail(username);
            user.setUserName(result.getString("username"));
            user.setEmail(result.getString("email"));
            user.setAddress(result.getString("address"));
            user.setPhone(result.getString("phone"));
            user.setGender(result.getInt("gender"));
            user.setRole(result.getInt("role"));
        }

        connection.close();

        return user;
    }

    public static boolean delProfile(String username) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        try {

            String sql = "DELETE FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public User getProfilebyMail(String email) throws SQLException,
            ClassNotFoundException {
//        String jdbcURL = "jdbc:mysql://localhost:3306/demo";
        Connection connection = DatabaseConnection.getInstance().getConnection();

        String sql = "SELECT * FROM users WHERE email = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
//            user.setUserName(result.getString("username"));
//            user.setEmail(username);
            user.setUserName(result.getString("username"));
            user.setEmail(result.getString("email"));
            user.setAddress(result.getString("address"));
            user.setPhone(result.getString("phone"));
            user.setGender(result.getInt("gender"));
            user.setRole(result.getInt("role"));
        }

        connection.close();

        return user;
    }

    public static boolean sendMail(String to, String subject, String text) {
        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", 587);
//        props.put("mail.debug", "false");

        // get Session
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("delwynshop2807@gmail.com", "spk280700");
                return new PasswordAuthentication("18110088.hcmute@gmail.com", "gapropp123");
            }
        });

        // compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            // send message
            Transport.send(message);

            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            props = null;
            return false;
        }
        props = null;
        return true;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "EXECUTE [dbo].[getProfile]  @username = user03";
        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, username);

        ResultSet result = statement.executeQuery();

        User user = null;

        if (result.next()) {
            user = new User();
//            user.setUserName(result.getString("username"));
//            user.setEmail(username);
            System.out.println(result.getString("username"));
            System.out.println(result.getString("password"));
            System.out.println(result.getString("email"));
//            user.setUserName(result.getString("username"));
//            user.setEmail(result.getString("email"));
//            user.setAddress(result.getString("address"));
//            user.setPhone(result.getString("phone"));
//            user.setGender(result.getInt("gender"));
//            user.setRole(result.getInt("role"));
        }

        connection.close();
        //Connection connection = DatabaseConnection.getInstance().getConnection();

    }
}
