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
public class insertitem extends HttpServlet {

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
        HttpSession session = request.getSession();
        int dem = 0;
        String destPage = "";
        String itemname = request.getParameter("itemname");
        String itemid = request.getParameter("itemid");
        String itemdes = request.getParameter("itemdes");
        String itemimg = request.getParameter("itemimg");

        int itemstock = 0;
        float itemprice = 0;
        User user = (User) session.getAttribute("user");
        if (session.getAttribute("user") == null) {
            request.setAttribute("msg", "|You need login fisrt|");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else if (user.getLevel() == 0) {
            request.setAttribute("msg", "|You not allow to do this|");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }

        if (request.getParameter("itemstock") != null) {
            if (Check.isNumber(request.getParameter("itemstock"))) {
                itemstock = Integer.parseInt(request.getParameter("itemstock"));
                if (itemstock <= 0) {
                    request.setAttribute("message3", "|Item's stock must be a number and above 0( Integer )|");
                    dem++;
                }
            } else {
                request.setAttribute("message3", "|Item's stock must be a number|");
                dem++;
            }
        } else {
            request.setAttribute("message3", "|You must enter a item's stock|");
            dem++;
        }

        if (request.getParameter("itemprice") != null) {
            if (Check.isFloat(request.getParameter("itemprice"))) {
                itemprice = Float.parseFloat(request.getParameter("itemprice"));
                if (itemprice <= 0) {
                    request.setAttribute("message5", "|Item's price must be a number and above 0( Float )|");
                    dem++;
                }
            } else {
                request.setAttribute("message5", "|Item's price must be a number and above 0 ( Float )|");
                dem++;
            }

        } else {
            request.setAttribute("message5", "|You must enter a item's price|");
            dem++;
        }

        if (itemid != null) {
            if (Check.isNumber(itemid)) {
                try {
                    if ((!Check.isExistItemId(itemid))) {
                        dem++;

                        request.setAttribute("message1", "|This item's id is already used|");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                }
            } else {
                dem++;
                request.setAttribute("message1", "|Item's ID must be a number|");
            }
        } else {
            dem++;
            request.setAttribute("message1", "|You must enter Item's ID|");
        }

        if (itemname == null) {
            request.setAttribute("message2", "|You must enter item's name|");
            dem++;
        }
        if (itemdes == null) {
            request.setAttribute("message6", "|You must enter item's description|");
            dem++;
        } else {
            if (itemdes.length() > 255) {
                dem++;
                request.setAttribute("message7", "|Description of item can't above 255 char|");

            }
        }
        if (itemimg == null) {
            request.setAttribute("message7", "|You must enter item's image|");
            dem++;
        } else {
            if (itemimg.length() > 255) {
                dem++;
                request.setAttribute("message7", "|URL of image can't above 255 char|");

            }
        }

        if (dem == 0) {
//            destPage = "single.jsp";
            InsertInfo insertInfo = new InsertInfo();
            try {
//                destPage = "error.jsp";
                boolean test = insertInfo.InsertItemInfomation(itemid, itemname, itemdes, itemimg, itemstock, itemprice);
                if (test) {
                    historyDAO hisDAO = new historyDAO();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
                    String time = now.format(formatter);
                    boolean updateHis = hisDAO.InsertHistory("INSERTITEM", time, "iditem :" + itemid + " by : " + user.getUserName());
                    destPage = "additem.jsp";
                    request.setAttribute("message9", "|Success to insert new item|");

                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            destPage = "additem.jsp";
            request.setAttribute("message9", "|Fail to insert new item|");
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
