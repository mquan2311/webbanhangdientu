/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class AdminController extends HttpServlet {

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
String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int level = 0;
        if (user == null) {
            request.setAttribute("msg", "You need login fisrt");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            level = user.getRole();
            if ((level == 0) && (!action.equals("changepw"))) {
                request.setAttribute("msg", "You not allow to do this");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            } else  {
                
                String useredit = request.getParameter("useredit");
                if (action != null) {
                    if (action.equals("usertable")) {
                        UserDAO userDAO = new UserDAO();

                        try {
                            List<User> listUser = userDAO.AllListUser();
                            request.setAttribute("listUser", listUser);

                        } catch (SQLException | ClassNotFoundException e) {
                            throw new ServletException(e);

                        }
                        request.setAttribute("message", "user");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                        dispatcher.forward(request, response);
                    } else if (action.equals("itemtable")) {
                        ProductDAO productDAO = new ProductDAO();

                        try {
                            List<Product> listProduct = productDAO.AllListProduct();
                            request.setAttribute("listProduct", listProduct);

                        } catch (SQLException | ClassNotFoundException e) {
                            throw new ServletException(e);

                        }
                        request.setAttribute("message", "item");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                        dispatcher.forward(request, response);
                    } 
                    else if (action.equals("histable"))
                    {
                        historyDAO hisDAO = new historyDAO();
                        try {
                            List<History> listHistory = hisDAO.AllListHistory();
                            request.setAttribute("listHistory", listHistory);

                        } catch (SQLException | ClassNotFoundException e) {
                            throw new ServletException(e);

                        }
                        request.setAttribute("message", "history");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                        dispatcher.forward(request, response);
                    }
                    else if (action.equals("purchasetable"))
                    {
                        historyDAO hisDAO = new historyDAO();
                        try {
                            List<History> listHistory = hisDAO.AllListHistory();
                            request.setAttribute("listHistory", listHistory);

                        } catch (SQLException | ClassNotFoundException e) {
                            throw new ServletException(e);

                        }
                        request.setAttribute("message", "history");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                        dispatcher.forward(request, response);
                    }
                    else if (action.equals("nothing")) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                        dispatcher.forward(request, response);
                    } else if (action.equals("edituser")) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("edituser.jsp");
                        dispatcher.forward(request, response);
                    } else if (action.equals("deleteuser")) {
                        String userdel = request.getParameter("userdel");
                        request.setAttribute("userdel", userdel);
                        UserDAO userDao = new UserDAO();
                        try {
                            if (userDao.delProfile(userdel)) {
//                                request.setAttribute("result", "xoaduoc");
                                historyDAO hisDAO = new historyDAO();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                                String time = now.format(formatter);
                                boolean updateHis = hisDAO.InsertHistory("DELUSER", time,"username: " +userdel + " by adminname: " + user.getUserName());
                                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController?action=usertable");
                                dispatcher.forward(request, response);
                            } else {
//                                request.setAttribute("result", "koxoaduoc");

                                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController?action=usertable");
                                dispatcher.forward(request, response);
                            }

                        } catch (SQLException | ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();

                        }

                    } else if (action.equals("deleteitem")) {
                        String itemdel = request.getParameter("itemdel");
                        request.setAttribute("itemdel", itemdel);
                        ProductDAO productDAO = new ProductDAO();
                        try {
                            if (productDAO.delProfile(itemdel)) {
//                                request.setAttribute("result", "xoaduoc");
                                historyDAO hisDAO = new historyDAO();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                                String time = now.format(formatter);
                                boolean updateHis = hisDAO.InsertHistory("DELITEM", time,"iditem: " + itemdel + " by adminname: " + user.getUserName());

                                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController?action=itemtable");
                                dispatcher.forward(request, response);
                            } else {
//                                request.setAttribute("result", "koxoaduoc");

                                RequestDispatcher dispatcher = request.getRequestDispatcher("AdminController?action=itemtable");
                                dispatcher.forward(request, response);
                            }

                        } catch (SQLException | ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();

                        }
                    } else if (action.equals("adduser")) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("adduser.jsp");
                        dispatcher.forward(request, response);
                    } else if (action.equals("additem")) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("additem.jsp");
                        dispatcher.forward(request, response);
                    } else if (action.equals("changepw")) {

                        String newpw = request.getParameter("newpw");
                        if ((newpw == null) || (newpw.equals(""))) {

                            request.setAttribute("msg", "|You must enter new password|");
                            request.setAttribute("code", "0");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                            dispatcher.forward(request, response);
                        } else if (!Check.isWord(newpw)) {

                            request.setAttribute("msg", "|Password cannot contain any specical characters ( spaces included )|");
                            request.setAttribute("code", "0");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                            dispatcher.forward(request, response);
                        } else {

                            InsertInfo changepw = new InsertInfo();
                            try {
                                historyDAO hisDAO = new historyDAO();
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                                String time = now.format(formatter);
                                boolean updateHis = hisDAO.InsertHistory("EDITPASS", time,"username: " + user.getUserName() + " old pass: " +user.getPassword() + " new pass: " + newpw);
                                boolean changePw = changepw.ChangePW(user.getUserName(), newpw);
                                UserDAO userDAO = new UserDAO();
                                
                                session.setAttribute("user", userDAO.getProfile(user.getUserName()));
                            } catch (SQLException | ClassNotFoundException e) {
                                throw new ServletException(e);

                            }

                            request.setAttribute("msg", "Successfully to change password");
                            request.setAttribute("code", "0");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                            dispatcher.forward(request, response);
                        }
                    }

                    request.setAttribute("msg", "Your command is not correct!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                } else {
//                request.setAttribute("message", "Ko bam vao trang user");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                    dispatcher.forward(request, response);
                }

            }
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
