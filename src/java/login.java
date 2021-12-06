/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author memft
 */
public class login extends HttpServlet {

    private static final long serialVersionUID = 1L;

//    public login() {
//        super();
//    }

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
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username != "") && (password != "")) {
            if (Check.isWord(username)) {
                if (Check.isWord(password)) {

                    UserDAO userDao = new UserDAO();
                    try {
                        User user = userDao.checkLogin(username, password);
                        String destPage = "login.jsp";

                        if (user != null) {
                            HttpSession session = request.getSession();
                            session.setAttribute("user", user);
                            session.setAttribute("status", "1");
//                            if (user.getLevel() == 1) {
//                                historyDAO hisDAO = new historyDAO();
//                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
//                                LocalDateTime now = LocalDateTime.now();
//                                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//                                String time = now.format(formatter);
//                                boolean updateHis = hisDAO.InsertHistory("ADMINLOG", time, "LOGIN# admin name: " + user.getUserName());
//                            }

                            destPage = "index.jsp";
                        } else {
                            user = null;
                            String message = "Invalid username/password";
                            request.setAttribute("message", message);
                        }

                        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                        dispatcher.forward(request, response);

                    } catch (SQLException | ClassNotFoundException ex) {
                        throw new ServletException(ex);
                    }
                } else {
                    String destPage = "login.jsp";
                    String message = "Password cannot contain any specical characters ( spaces included )";
                    request.setAttribute("message2", message);
                    RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                    dispatcher.forward(request, response);
                }
            } else {
                String destPage = "login.jsp";
                String message = "Username cannot contain any specical characters ( spaces included )";
                request.setAttribute("message1", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                dispatcher.forward(request, response);
            }

        } else if ((username == "") || (password == "")) {
            String destPage = "login.jsp";
            if (username == "") {
                String message1 = "You must enter username";
                request.setAttribute("message1", message1);
            }
            if (password == "") {
                String message2 = "You must enter password";
                request.setAttribute("message2", message2);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        }

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
