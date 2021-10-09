/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class addtocart extends HttpServlet {

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

        String username = "";

        if (session.getAttribute("user") == null) {
            request.setAttribute("msg", "|You need login fisrt|");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            User user = (User) session.getAttribute("user");
            username = user.getUserName();
        }
        
        String msg = (String)request.getAttribute("msg");
        if (msg == null) { msg = "";}
        
        
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        } 
        if (action.equals("nothing")) {
            
            List<Cart> listCartupdate = (List<Cart>) request.getAttribute("cartupdate");
            session.setAttribute("cart", listCartupdate);

            RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
            dispatcher.forward(request, response);
        }
        

        String itemid = request.getParameter("itemid");
        if (itemid == null) {
            itemid = "";
        }

        int quantity = 0;

        ProductDAO productDAO = new ProductDAO();

        try {
            List<Product> listProduct = productDAO.AllListProduct();
            request.setAttribute("listProduct", listProduct);

        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException(e);

        }
        List<Cart> listCart = null;
        if (session.getAttribute("cart") == null) {
            listCart = new ArrayList<Cart>();
            if (listCart != null) {
                for (Cart cart : listCart) {
                    if ((cart.getItemId().equals(itemid)) && (cart.getUserId().equals(username))) {
                        quantity = cart.getQuantity() + 1;
                        cart.setQuantity(quantity);

                    }

                }

            } else {
                if (itemid != null) {
                    quantity = 1;
                    Cart newcart = new Cart(itemid, username, quantity);
                    listCart.add(newcart);
                }
            }
            if (quantity == 0) {
                if (itemid != null) {
                    quantity = 1;
                    Cart newcart = new Cart(itemid, username, quantity);
                    listCart.add(newcart);
                }
            }
        } else {
            listCart = (List<Cart>) session.getAttribute("cart");
            if (listCart != null) {
                for (Cart cart : listCart) {
                    if ((cart.getItemId().equals(itemid)) && (cart.getUserId().equals(username))) {
                        quantity = cart.getQuantity() + 1;
                        cart.setQuantity(quantity);

                    }

                }

            } else {
                quantity = 1;
                Cart newcart = new Cart(itemid, username, quantity);
                listCart.add(newcart);
            }
            if (quantity == 0) {
                quantity = 1;
                Cart newcart = new Cart(itemid, username, quantity);
                listCart.add(newcart);
            }
        }

        session.setAttribute("cart", listCart);

        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
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
