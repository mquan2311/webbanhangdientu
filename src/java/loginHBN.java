/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.*;
//@WebServlet("/loginHBN")

/**
 *
 * @author memft
 */
public class loginHBN extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDaoHBN loginDao;

    public void init() {
        loginDao = new UserDaoHBN();
    }

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

        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserHBN user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ((username != "") && (password != "")) {
            if (Check.isWord(username)) {
                if (Check.isWord(password)) {

                    if (loginDao.validate(username, password)) {

                        RequestDispatcher dispatcher = request.getRequestDispatcher("login");
                        dispatcher.forward(request, response);
                    } else {
//            throw new Exception("Login not successful..");
                        user = null;
                        String message = "Invalid username/password";
                        request.setAttribute("message", message);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                        dispatcher.forward(request, response);

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

/**
 * @email Ramesh Fadatare
 */
