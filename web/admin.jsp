<%-- 
    Document   : admin
    Created on : Dec 18, 2020, 6:04:35 PM
    Author     : memft
--%>

<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/admincss.css" rel="stylesheet" type="text/css" media="all" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
    </head>
    <body>
        <% String msg = (String) request.getAttribute("message");
            if (msg == null) {
                msg = "";
            }
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }

            //     Product product = new Product();
            List<Product> items = (List<Product>) request.getAttribute("listProduct");
            List<User> users = (List<User>) request.getAttribute("listUser");
            List<History> history = (List<History>) request.getAttribute("listHistory");

//            if (items != null) {
//                for (Product product : items) {
//                    String itemname = product.getItemName();
//                    String itemdes = product.getItemDes();
//                    Float itemprice = product.getItemPrice();
//                    String itemimg = product.getItemImg();
//                }
//            }
        %> 
        <div class="container">
            <div class="menu">
                <div class="title">
                    <h1>Dashboard</h1>
                </div>
                <ul>
                    <li><a href="AdminController?action=usertable"><i class="ion-person-stalker"></i>Accounts</a></li>
                    <li><a href="AdminController?action=itemtable"><i class="ion-archive"></i>Category</a></li>
                    <li><a href="AdminController?action=histable"><i class="ion-archive"></i>History</a></li>
                    <li><a href="AdminController?action=purchasetable"><i class="ion-archive"></i>History Purchase</a></li>
                    <li><a href="#" onclick="window.open('AdminController?action=adduser', '', 'width=800,height=800')"><i class="ion-ios-cloud-upload-outline"></i>Add new user</a></li>
                    <li><a href="#" onclick="window.open('AdminController?action=additem', '', 'width=800,height=800')"><i class="ion-ios-cloud-upload-outline"></i>Add new item</a></li>
                    <li><a href="login.jsp"><i class="ion-ios-undo-outline"></i>Back</a></li>
                </ul>
                <span class="credit">Admin page - HCMUTE</span>
            </div>
            <div class="panel">
                <div class="header">
                    <h1>Admin management</h1>
                </div>
                <% if (action.equals("usertable")) {%>
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <th data-thead="account">Username</th>
                                <th data-thead="role">Role</th>
                                <th data-thead="email">E-mail</th>
                                <th data-thead="phone">Phone</th>
                                <th data-thead="editbox">Edit</th>
                                <th data-thead="delbox">Delete</th>
                            </tr>
                        </thead>
                    </table>
                </div>
                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <%  if (users != null) {
                                    for (User user : users) {
                                        String username = user.getUserName();
                                        int userlevel = user.getLevel();
                                        String useremail = user.getEmail();
                                        String userphone = user.getPhone();%>
                            <tr>
                                <td data-tbody="account"><%=username%></td>
                                <td data-tbody="role"><%=userlevel%></td>
                                <td data-tbody="email"><%=useremail%></td>
                                <td data-tbody="phone"><%=userphone%></td>
                                <td data-tbody="editbox"><a href="#" onclick="window.open('edituser.jsp?action=edit&useredit=<%=username%>', '', 'width=800,height=800')"><i class="ion-compose"></i></a></td>
                                <td data-tbody="delbox"><a href="#" onclick="var test = confirm('Are you sure you want to delete this user?');
                                        if (test == true)
                                        {
                                            window.open('AdminController?action=deleteuser&userdel=<%=username%>');
                                        }

                                                           "><i class="ion-android-delete" ></i></a></td>
                            </tr>  
                            <% }
                                }%>
                        </tbody>
                    </table>
                </div>
                <% } else if (action.equals("itemtable")) { %> 
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <th data-thead="name">Item name</th>
                                <th data-thead="price">Item price</th>
                                <th data-thead="stock">Item stock</th>
                                <th data-thead="des">Item decription</th>
                                <th data-thead="img">Item image</th>
                                <th></th>
                                <th data-thead="editbox">Edit</th>
                                <th data-thead="delbox">Delete</th>
                            </tr>
                        </thead>
                    </table>
                </div>

                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <%  if (items != null) {
                                    for (Product product : items) {
                                        String itemid = product.getItemId();
                                        String itemname = product.getItemName();
                                        String itemdes = product.getItemDes();
                                        int itemstock = product.getItemStock();
                                        Float itemprice = product.getItemPrice();
                                        String itemimg = product.getItemImg();%>
                            <tr>

                                <td data-thead="name"><%=itemname%></td>
                                <td data-thead="price"><%=itemprice%></td>
                                <td data-thead="stock"><%=itemstock%></td>
                                <td data-thead="des"><%=itemdes%></td>
<!--                                <th data-thead="img"><%=itemimg%></th>-->
                                <td data-thead="img"><div class="css3"><img src="<%=itemimg%>" alt=""/></div></td>
                                <td> </td>
                                <td data-tbody="editbox"><a href="#" onclick="window.open('edititem.jsp?action=edit&itemedit=<%=itemid%>', '', 'width=800,height=800')"><i align-items="right" class="ion-compose"></i></a></td>
                                <td data-tbody="delbox"><a href="#" onclick="var test = confirm('Are you sure you want to delete this item?');
                                        if (test == true)
                                        {
                                            window.open('AdminController?action=deleteitem&itemdel=<%=itemid%>');
                                        }

                                                           "><i class="ion-android-delete" ></i></a></td>

                            </tr>    
                            <% }
                                }%>
                        </tbody>
                    </table>
                </div>            








                <% } else if (action.equals("histable")) { %> 
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <th data-thead="name">History time</th>
                                <th data-thead="price">History type</th>
                                <th data-thead="stock">History des</th>

                            </tr>
                        </thead>
                    </table>
                </div>

                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <%
                                if (history != null) {
                                    for (History his : history) {
                                        String type = his.getTypehis();
                                        String time = his.getTimehis();
                                        String des = his.getDeshis();

                            %>
                            <tr>

                                <td data-thead="name"><%=time%></td>
                                <td data-thead="price"><%=type%></td>
                                <td data-thead="stock"><%=des%></td>


                            </tr>    
                            <% }
                                }%>
                        </tbody>
                    </table>
                </div> 

                <% } else if (action.equals("purchasetable")) {
                    float total = 0;
                %> 
                <div class="tbl-header">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <thead>
                            <tr>
                                <th data-thead="name">History time</th>
                                <th data-thead="price">History type</th>
                                <th data-thead="stock">History des</th>

                            </tr>
                        </thead>
                    </table>
                </div>

                <div class="tbl-content">
                    <table cellpadding="0" cellspacing="0" border="0">
                        <tbody>
                            <%
                                if (history != null) {
                                    for (History his : history) {
                                        float sum = 0;
                                        if (his.getTypehis().equals("PURCHASE")) {
                                            int dem = 0;

                                            char z = '$';
                                            char c;
                                            String type = his.getTypehis();
                                            String time = his.getTimehis();
                                            String des = his.getDeshis();
                                            for (int i = des.length() - 1; i > 0; i--) {
                                                c = des.charAt(i);

                                                if (Character.compare(z, c) == 0) {
                                                    dem = i;
                                                    break;
                                                }

                                            }
                                            String price = des.substring(dem + 1, des.length());
                                            if (Check.isFloat(price)) {
                                                sum = Float.parseFloat(price);

                                            }
                            %>
                            <tr>

                                <td data-thead="name"><%=time%></td>
                                <td data-thead="price"><%=type%></td>
                                <td data-thead="stock"><%=des%></td>


                            </tr>    
                            <% }
                                        total = total + sum;
                                    }
                                }%>
                            <tr>
                                <td data-thead="name"></td>
                                <td data-thead="price">Total incomes</td>
                                <td data-thead="stock"><%=total%></td>
                            </tr>
                        </tbody>
                    </table>
                </div> 

                <% }%>
            </div>
        </div>
        <script>
            function Editprofile(String para)
            {
            window.open("edituser.jsp?action=edit&useredit=para", "", "width=800,height=800");
            }
            function Deleteprofile(String para)
            {

                window.open("index.jsp", "", "width=800,height=800");
            }

        </script>


    </body>
</html>
