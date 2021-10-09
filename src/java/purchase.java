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
public class purchase extends HttpServlet {

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
        int check = 0;
        int test = 0;
        String username = "";
        String showname = "";
        String address = "";
        String email = "";
        String phone = "";
        String city = "";
        String country = "";

        float total = 0;
//        Float total = request.getAttribute("total");

        if (request.getParameter("total") != null) {
            if (Check.isFloat(request.getParameter("total"))) {
                total = Float.parseFloat(request.getParameter("total"));
            }
        }
        List<Cart> listCart = (List<Cart>) session.getAttribute("cart");

        if (total == 15) {
            session.setAttribute("cart", listCart);
            request.setAttribute("msg", "Your cart is empty");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addtocart");
            dispatcher.forward(request, response);
        } else if (total < 0) {
            session.setAttribute("cart", listCart);
            request.setAttribute("msg", "Your item's quantity must above 0(Choose again)");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addtocart");
            dispatcher.forward(request, response);
        }

        if (session.getAttribute("user") == null) {
            request.setAttribute("msg", "You need login fisrt");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            User user = (User) session.getAttribute("user");

            username = user.getUserName();
            showname = user.getShowName();
            address = user.getAddress();
            email = user.getEmail();
            phone = user.getPhone();
            city = user.getCity();
            country = user.getCountry();

        }

//        List<Cart> listCart = (List<Cart>) session.getAttribute("cart");
        if (listCart != null) {
            for (Cart cart : listCart) {
                if (username.equals(cart.getUserId())) {
                    ProductDAO productDAO = new ProductDAO();
                    try {
                        List<Product> items = productDAO.AllListProduct();
                        if (items != null) {
                            for (Product product : items) {
                                if (product.getItemId().equals(cart.getItemId())) {
                                    check = 1;
                                    test = test + 1;
                                    int itemquantity = cart.getQuantity();
                                    int itemstock = product.getItemStock();
                                    String itemid = product.getItemId();
                                    if (itemstock == 0) {
                                        dem++;
                                        int temp = 1;
                                        request.setAttribute("msg", "Your cart has item is out of stock");
//                                      session.setAttribute("cart", listCart);
                                        RequestDispatcher dispatcher = request.getRequestDispatcher("editcart?quantity=" + temp + "&itemidchange=" + itemid + "");
                                        dispatcher.forward(request, response);
                                    } else if (itemquantity > itemstock) {

                                        dem++;

                                        request.setAttribute("msg", "Your item's quantity can't above item's stock");
//                                        session.setAttribute("cartupdate", listCart);
//                                        RequestDispatcher dispatcher = request.getRequestDispatcher("addtocart?action=nothing");
                                        int temp = 1;
                                        session.setAttribute("cart", listCart);
                                        RequestDispatcher dispatcher = request.getRequestDispatcher("editcart?quantity=" + temp + "&itemidchange=" + itemid + "");
                                        dispatcher.forward(request, response);

                                    }
                                    if (itemquantity <= 0) {
//                                   
                                        dem++;

                                        request.setAttribute("msg", "Your item's quantity must above 0(Choose again)");
                                        int temp = 1;
//                                        cart.setQuantity(temp);
//                                        session.setAttribute("cartupdate", listCart);
//                                        RequestDispatcher dispatcher = request.getRequestDispatcher("addtocart?action=nothing");
                                        session.setAttribute("cart", listCart);
                                        RequestDispatcher dispatcher = request.getRequestDispatcher("editcart?quantity=" + temp + "&itemidchange=" + itemid + "");
                                        dispatcher.forward(request, response);

                                    }
                                    if (itemquantity % 1 != 0) {
                                        dem++;

                                        request.setAttribute("msg", "Your item's quantity can't be FLOAT");
                                        int temp = 1;
//                                        session.setAttribute("cartupdate", listCart);
//                                        RequestDispatcher dispatcher = request.getRequestDispatcher("addtocart?action=nothing");
                                        session.setAttribute("cart", listCart);
                                        RequestDispatcher dispatcher = request.getRequestDispatcher("editcart?quantity=" + temp + "&itemidchange=" + itemid + "");
                                        dispatcher.forward(request, response);

                                    }
                                }
                            }
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                        throw new ServletException(e);

                    }

                }
            }
        }

        if ((dem == 0) && (check == 1)) {

            if (listCart != null) {
                ProductDAO productDAO = new ProductDAO();
                int itemquantity = 0;
                int itemstock = 0;
                int stockafter = 0;
                List<Product> items = null;
                try {
                    items = productDAO.AllListProduct();
                } catch (SQLException | ClassNotFoundException e) {
                    throw new ServletException(e);

                }

                for (Cart cart : listCart) {
                    if (username.equals(cart.getUserId())) {

                        try {

                            if (items != null) {
                                for (Product product : items) {
                                    if (product.getItemId().equals(cart.getItemId())) {
                                        itemquantity = cart.getQuantity();
                                        itemstock = product.getItemStock();
                                        String itemid = product.getItemId();
                                        test = test - 1;
                                        if (itemstock >= itemquantity) {
                                            stockafter = itemstock - itemquantity;
//                                                listCart.remove(cart);
                                            productDAO.delQuantity(itemid, stockafter);

                                        }
//                                        else if (itemstock == itemquantity) {
//                                            productDAO.delProfile(itemid);
////                                                listCart.remove(cart);
//
//                                        }

                                    }

                                }
                            }

                        } catch (SQLException | ClassNotFoundException e) {
                            throw new ServletException(e);

                        }

                    }

                }

            }
            while (test > 0) {
                if (listCart != null) {
                    for (Cart cart : listCart) {
                        if (cart.getUserId().equals(username)) {
                            listCart.remove(cart);
                            test--;
                            break;

                        }
                    }
                } else {
                    break;
                }
            }
            User user = (User) session.getAttribute("user");
            session.setAttribute("cart", listCart);
            session.setAttribute("cartupdate", listCart);
            UserDAO userDao = new UserDAO();
            userDao.sendMail(email, "Check purchase", "Thanks for purchase, your total price is : " + total + System.lineSeparator() + " More info below... " + System.lineSeparator()
                    + "At address :" + address + System.lineSeparator() + ""
                    + "District :" + country + System.lineSeparator() + ""
                    + "City : " + city + System.lineSeparator() + ""
                    + "Phone : " + phone + System.lineSeparator() + ""
                    + "Hope see you again");
            historyDAO hisDAO = new historyDAO();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd  HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
            String time = now.format(formatter);
            try {
                boolean updateHis = hisDAO.InsertHistory("PURCHASE", time, "username :" + user.getUserName() + " totalprice : $" + total);
                updateHis = hisDAO.InsertHistory("MAILSEND", time, "PURCHASEMAIL# email: " +email+"  totalprice : $"+total);
            } catch (SQLException | ClassNotFoundException ex) {
                throw new ServletException(ex);
            }
            request.setAttribute("msg", "Thanks for purchase, check your mail");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addtocart?action=nothing");
            dispatcher.forward(request, response);
        } else {
            session.setAttribute("cartupdate", listCart);
            if (check == 0) {
                request.setAttribute("msg", "Your cart is empty");
            }
//            request.setAttribute("msg", "Your item's quantity can't above item's stock");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addtocart?action=nothing");
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
