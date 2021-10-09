/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class insertinfo extends HttpServlet {

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
        String destPage = "register.jsp";
        String message = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String showname = request.getParameter("showname");
        String phone = request.getParameter("phone");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String email = request.getParameter("email");
        String action = request.getParameter("action");

        int level = 0;
        if (request.getParameter("level") != null) {
            if (Check.isNumber(request.getParameter("level"))) {
                level = Integer.parseInt(request.getParameter("level"));
            } else {
                request.setAttribute("message5", "Level must be number");
                dem++;
            }
        } else {
            level = 0;
        }

        if (username.equals("Name")) {
            username = "";
        }
        if (showname.equals("Show name")) {
            showname = "";
        }
        if (email.equals("E-Mail")) {
            email = "";
        }
        if (password.equals("Password")) {
            password = "";
        }
        if (address.equals("Address")) {
            address = "";
        }
        if (country.equals("District")) {
            country = "";
        }
        if (city.equals("City")) {
            city = "";
        }
        if (phone.equals("Phone Number")) {
            phone = "";
        }

        if (showname == "") {
            dem++;
            request.setAttribute("message6", "|You must enter show name");
        }
        if (address == "") {
            dem++;
            request.setAttribute("message7", "|You must enter address");
        }
        if (country == "") {
            dem++;
            request.setAttribute("message8", "|You must enter district");
        }
        if (city == "") {
            dem++;
            request.setAttribute("message9", "|You must enter city");
        }
        if (username == "") {
            dem++;
            request.setAttribute("message1", "|You must enter username|");
        } else {
            request.setAttribute("message1", "");
            if (Check.isWord(username)) {
                request.setAttribute("message1", "");
                try {
                    if (!Check.isExistusername(username)) {
                        dem++;
                        request.setAttribute("message1", "|This username is already used|");
                    } else {
                        request.setAttribute("message1", "");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                dem++;
                request.setAttribute("message1", "|Username cannot contain any specical characters ( spaces included )|");
            }
        }
        if (email == "") {
            dem++;
            request.setAttribute("message2", "|You must enter email|");
        } else {
            request.setAttribute("message2", "");
            if (Check.isEmail(email)) {
                request.setAttribute("message2", "");
                try {
                    if (!Check.isExistemail(email)) {
                        dem++;
                        request.setAttribute("message2", "|This email is already used|");
                    } else {
                        request.setAttribute("message2", "");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
//                "|Email must be form abc@abc.abc|"
                dem++;
                request.setAttribute("message2", "|Email must be form abc@abc.abc|");
            }
        }
        if (phone == "") {
            dem++;
            request.setAttribute("message4", "|You must enter phone number|");
        } else {
            request.setAttribute("message4", "");
            if (Check.isNumber(phone)) {
                request.setAttribute("message4", "");
                try {
                    if (!Check.isExistphone(phone)) {
                        dem++;
                        request.setAttribute("message4", "|This phone number is already used|");
                    } else {
                        request.setAttribute("message4", "");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                dem++;
                request.setAttribute("message4", "|Phone number must be a digits|");
            }
        }
        if (password == "") {
            dem++;
            request.setAttribute("message3", "|You must enter password|");
        } else {
            if (!Check.isWord(password)) {
                dem++;
                request.setAttribute("message3", "|Password cannot contain any specical characters ( spaces included )|");
            }

        }
//        String test1 = Integer.toString(dem);
//    
//        request.setAttribute("dem", test1);
//        request.setAttribute("dem1", username);
//        request.setAttribute("dem2", email);
//        request.setAttribute("dem3", password);
//        request.setAttribute("dem4", phone);
//        request.setAttribute("dem5", city);
//        request.setAttribute("dem6", country);
//        request.setAttribute("dem7", address);
//        request.setAttribute("dem8", showname);
//        (String username, String password, String showname, String address, String email, String phone, String city, String country)
        if (dem == 0) {
//            destPage = "single.jsp";
            InsertInfo insertInfo = new InsertInfo();
            historyDAO hisDAO = new historyDAO();
            try {
//                destPage = "error.jsp";

                boolean test = insertInfo.InsertInfomation(username, password, showname, address, email, phone, city, country, level);

                if (test) {
                    if (action.equals("user")) {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                        String time = now.format(formatter);
                        boolean updateHis = hisDAO.InsertHistory("REGISTER", time, username + " " + password + " " + email + " " + phone + " ");
                        destPage = "register.jsp";
                        request.setAttribute("message5", "Sign Up Success");
                    } else if (action.equals("admin")) {
                        HttpSession session = request.getSession();
                        User user = (User) session.getAttribute("user");
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                        String time = now.format(formatter);
                        boolean updateHis = hisDAO.InsertHistory("ADDUSER", time, username + " " + password + " " + email + " " + phone + " by adminname: " + user.getUserName());
                        destPage = "adduser.jsp";
                        request.setAttribute("message5", "Sign Up Success");
                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
                    dispatcher.forward(request, response);
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            if (action.equals("user")) {
                destPage = "register.jsp";
            } else if (action.equals("admin")) {
                destPage = "adduser.jsp";
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
























//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import model.*;
//
///**
// *
// * @author memft
// */
//public class insertinfo extends HttpServlet {
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        int dem = 0;
//        String destPage = "register.jsp";
//        String message = "";
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String address = request.getParameter("address");
//        String showname = request.getParameter("showname");
//        String phone = request.getParameter("phone");
//        String city = request.getParameter("city");
//        String country = request.getParameter("country");
//        String email = request.getParameter("email");
//        String action = request.getParameter("action");
//        CheckTarget checkTarget = new Adapter();
//        int level = 0;
//        if (request.getParameter("level") != null) {
//            if (checkTarget.verifyNumber(request.getParameter("level"))) {
//                level = Integer.parseInt(request.getParameter("level"));
//            } else {
//                request.setAttribute("message5", "Level must be number");
//                dem++;
//            }
//        } else {
//            level = 0;
//        }
//
//        if (username.equals("Name")) {
//            username = "";
//        }
//        if (showname.equals("Show name")) {
//            showname = "";
//        }
//        if (email.equals("E-Mail")) {
//            email = "";
//        }
//        if (password.equals("Password")) {
//            password = "";
//        }
//        if (address.equals("Address")) {
//            address = "";
//        }
//        if (country.equals("District")) {
//            country = "";
//        }
//        if (city.equals("City")) {
//            city = "";
//        }
//        if (phone.equals("Phone Number")) {
//            phone = "";
//        }
//
//        if (showname == "") {
//            dem++;
//            request.setAttribute("message6", "|You must enter show name");
//        }
//        if (address == "") {
//            dem++;
//            request.setAttribute("message7", "|You must enter address");
//        }
//        if (country == "") {
//            dem++;
//            request.setAttribute("message8", "|You must enter district");
//        }
//        if (city == "") {
//            dem++;
//            request.setAttribute("message9", "|You must enter city");
//        }
//        if (username == "") {
//            dem++;
//            request.setAttribute("message1", "|You must enter username|");
//        } else {
//            request.setAttribute("message1", "");
//            if (checkTarget.verifyWord(username)) {
//                request.setAttribute("message1", "");
//                if (!checkTarget.verifyExistusername(username)) {
//                    dem++;
//                    request.setAttribute("message1", "|This username is already used|");
//                } else {
//                    request.setAttribute("message1", "");
//                }
//            } else {
//                dem++;
//                request.setAttribute("message1", "|Username cannot contain any specical characters ( spaces included )|");
//            }
//        }
//        if (email == "") {
//            dem++;
//            request.setAttribute("message2", "|You must enter email|");
//        } else {
//            request.setAttribute("message2", "");
//            if (checkTarget.verifyEmail(email)) {
//                request.setAttribute("message2", "");
//                if (!checkTarget.verifyExistemail(email)) {
//                    dem++;
//                    request.setAttribute("message2", "|This email is already used|");
//                } else {
//                    request.setAttribute("message2", "");
//                }
//            } else {
//     
//                dem++;
//                request.setAttribute("message2", "|Email must be form abc@abc.abc|");
//            }
//        }
//        if (phone == "") {
//            dem++;
//            request.setAttribute("message4", "|You must enter phone number|");
//        } else {
//            request.setAttribute("message4", "");
//            if (checkTarget.verifyNumber(phone)) {
//                request.setAttribute("message4", "");
//                if (!checkTarget.verifyExistphone(phone)) {
//                    dem++;
//                    request.setAttribute("message4", "|This phone number is already used|");
//                } else {
//                    request.setAttribute("message4", "");
//                }
//            } else {
//                dem++;
//                request.setAttribute("message4", "|Phone number must be a digits|");
//            }
//        }
//        if (password == "") {
//            dem++;
//            request.setAttribute("message3", "|You must enter password|");
//        } else {
//            if (!checkTarget.verifyWord(password)) {
//                dem++;
//                request.setAttribute("message3", "|Password cannot contain any specical characters ( spaces included )|");
//            }
//
//        }
//
//        if (dem == 0) {
//
//            InsertInfo insertInfo = new InsertInfo();
//            historyDAO hisDAO = new historyDAO();
//            try {
//
//
//                boolean test = insertInfo.InsertInfomation(username, password, showname, address, email, phone, city, country, level);
//
//                if (test) {
//                    if (action.equals("user")) {
//                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
//                        LocalDateTime now = LocalDateTime.now();
//                        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//                        String time = now.format(formatter);
//                        boolean updateHis = hisDAO.InsertHistory("REGISTER", time, username + " " + password + " " + email + " " + phone + " ");
//                        destPage = "register.jsp";
//                        request.setAttribute("message5", "Sign Up Success");
//                    } else if (action.equals("admin")) {
//                        HttpSession session = request.getSession();
//                        User user = (User) session.getAttribute("user");
//                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
//                        LocalDateTime now = LocalDateTime.now();
//                        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//                        String time = now.format(formatter);
//                        boolean updateHis = hisDAO.InsertHistory("ADDUSER", time, username + " " + password + " " + email + " " + phone + " by adminname: " + user.getUserName());
//                        destPage = "adduser.jsp";
//                        request.setAttribute("message5", "Sign Up Success");
//                    }
//                    RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
//                    dispatcher.forward(request, response);
//                }
//            } catch (SQLException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            if (action.equals("user")) {
//                destPage = "register.jsp";
//            } else if (action.equals("admin")) {
//                destPage = "adduser.jsp";
//            }
//        }
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
//        dispatcher.forward(request, response);
//
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
