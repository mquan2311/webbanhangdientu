/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.*;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author memft
 */
public class editinfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int dem = 0;
        HttpSession session = request.getSession();
        String message = "";
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String showname = request.getParameter("showname");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String email = request.getParameter("email");

        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        };
        int level = 0;

        String destPage = "";

        if (act.equals("edit")) {
            destPage = "edituser.jsp";
        } else if (act.equals("nothing")) {
            destPage = "login.jsp";
            session.removeAttribute("useredit");
        }
        User user = null;

        String useremail = "";
        String userusername = "";
        String userphone = "";

        if (act.equals("nothing")) {
            user = (User) session.getAttribute("user");
            useremail = user.getEmail();
            userphone = user.getPhone();
            userusername = user.getUserName();
            username = userusername;
//            request.setAttribute("msg", "ko useredit");
//            destPage = "error.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
//                        dispatcher.forward(request, response);
        } else {
            user = (User) session.getAttribute("useredit");
            useremail = user.getEmail();
            userphone = user.getPhone();
            userusername = user.getUserName();
//            request.setAttribute("msg", user.getUserName());
//            destPage = "error.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
//                        dispatcher.forward(request, response);

        }
        if (request.getParameter("level") != null) {
            if (Check.isNumber(request.getParameter("level"))) {
                level = Integer.parseInt(request.getParameter("level"));
            } else {
                request.setAttribute("message1", "Level must be number");
                dem++;
            }
        } else {
            level = user.getRole();
        }

//        username = "admin";
//        address = "Test";
//        showname ="Test";
//        phone ="12";
//        city = "test";
//        country="test";
//        email="memfth123@gmail.com";
        if (!Check.isWord(showname)) {
            dem++;
            message = "Showname cannot contain any specical characters ( spaces included )";
            request.setAttribute("message3", message);
        }
        if (!Check.isNumber(phone)) {
            dem++;
            message = "Phone cannot contain any specical characters and word ( spaces included )";
            request.setAttribute("message4", message);
        } else {
            try {
                if ((!Check.isExistphone(phone)) && (!Check.isEqual(phone, userphone))) {
                    dem++;

                    request.setAttribute("message4", "This phone is already used");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (!Check.isEmail(email)) {
            dem++;
            message = "Your email is not valid";
            request.setAttribute("message5", message);
        } else {
            try {
                if ((!Check.isExistemail(email)) && (!Check.isEqual(email, useremail))) {
                    dem++;
                    request.setAttribute("message5", "This email is already used");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (!Check.isWord(username)) {
            dem++;
            message = "Your username is not valid";
            request.setAttribute("message2", message);
        } else {
            try {
                if ((!Check.isExistusername(username)) && (!Check.isEqual(username, userusername))) {
                    dem++;
                    request.setAttribute("message2", "This username is already used");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (dem == 0) {//(String username, String showname, String address, String email, String phone, String city, String country)
            UpdateInfo updateInfo = new UpdateInfo();
//            User user = userDao.UpdateInfomation(username, showname,address,email,phone,city,country);
            try {
//                            User user = userDao.UpdateInfomation(username,showname,address,email,phone,city,country);
                if (act.equals("edit")) {
                    boolean test = updateInfo.UpdateInfomation(userusername, username, showname, address, email, phone, city, country, level);
                    user = updateInfo.Up(username);
                } else {
                    boolean test = updateInfo.UpdateInfomation(userusername, username, showname, address, email, phone, city, country, level);
                    user = updateInfo.Up(username);
                }

                destPage = "shop.jsp";

//                            if (test) { destPage="login.jsp";}
                if (user != null) {
                    if (!act.equals("edit")) {
                        session.setAttribute("user", user);
                        destPage = "login.jsp";
                        message = "Successful change";
                        request.setAttribute("message6", message);
                        historyDAO hisDAO = new historyDAO();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                        String time = now.format(formatter);
                        boolean updateHis = hisDAO.InsertHistory("EDITUSER", time, "user edited: " + username);
                    } else {
                        session.setAttribute("useredit", user);
                        User usertemp = (User) session.getAttribute("user");
                        String usertemp2 = usertemp.getUserName();
                        if (usertemp2.equals(userusername)) {
                            session.setAttribute("user", user);
                        }
                        historyDAO hisDAO = new historyDAO();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                        String time = now.format(formatter);
                        boolean updateHis = hisDAO.InsertHistory("EDITUSER", time, "user edited: " + username + " by admin name: " + user.getUserName());
                        destPage = "edituser.jsp?action=edit&useredit=" + username + "";
                        message = "Successful change";
                        request.setAttribute("message6", message);
                    }

                }

                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();

            }
        } else {
            if (!act.equals("edit")) {
                destPage = "login.jsp";
            } else {
                destPage = "edituser.jsp?action=edit&useredit=" + userusername + "";
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
