<%-- 
    Document   : edititem
    Created on : Dec 21, 2020, 3:23:58 PM
    Author     : memft
--%>

<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit item</title>
    </head>
    <body>
        <%
           
            
            String itemid = (String)request.getParameter("itemedit");
            String itemidold = itemid;
            
            ProductDAO productDAO = new ProductDAO();
            
            Product product = productDAO.getItemInfo(itemidold);
            
            String itemname = product.getItemName();
            
            String itemimg = product.getItemImg();
            
            String itemdes = product.getItemDes();
            
            Float itemprice = product.getItemPrice();
            
            int itemstock = product.getItemStock();
            
            String message1 = (String) request.getAttribute("message1");
            if (message1 == null) {
                message1 = "";
            }
            String message2 = (String) request.getAttribute("message2");
            if (message2 == null) {
                message2 = "";
            }
            String message3 = (String) request.getAttribute("message3");
            if (message3 == null) {
                message3 = "";
            }
            String message4 = (String) request.getAttribute("message4");
            if (message4 == null) {
                message4 = "";
            }
            String message5 = (String) request.getAttribute("message5");
            if (message5 == null) {
                message5 = "";
            }
            String message6 = (String) request.getAttribute("message6");
            if (message6 == null) {
                message6 = "";
            }
            String message7 = (String) request.getAttribute("message7");
            if (message7 == null) {
                message7 = "";
            }
            String msg = (String) request.getAttribute("msg");
            if (msg == null) {
                msg = "";
            }


        %>
        <form action="modifyitem?act=edit&itemidold=<%=itemidold%>" method="post">
            <div class="login">
                <div class="wrap">

                    <div class="col_1_of_login span_1_of_login">
                        <div class="login-title">
                            <h4 class="title" align="right">User</h4>
                            <div class="comments-area">


                                <p>
                                    <label>Item's ID</label>
                                    <span><%=message1%></span>    
                                    <input type="text" name="itemid" value="<%=itemid%>"  onfocus="if (this.value == '<%=itemid%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=itemid%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Item's Name</label>
                                    <span><%=message2%></span>
                                    <input type="text" name="itemname" value="<%=itemname%>" onfocus="if (this.value == '<%=itemname%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=itemname%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Item's Stock</label>
                                    <span><%=message3%></span>
                                    <input type="text" name="itemstock" value="<%=itemstock%>" onfocus="if (this.value == '<%=itemstock%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=itemstock%>';
                                                    }">
                                </p>


                                <p>
                                    <span><%=message4%></span>
                                    <input type="submit" value="Edit">
                                </p>
                                <span> <%=msg%></span>


                                <!--					</form>-->
                            </div>
                        </div>
                    </div>


                    <div class="col_1_of_login span_1_of_login">
                        <div class="login-title">
                            <h4 class="title"> information </h4>
                            <div class="comments-area">
                                <!--						<form action="logout" method="post">-->

                                <p>
                                    <label>Item's Price</label>
                                    <span><%=message5%></span>
                                    <input type="text" name="itemprice" value="<%=itemprice%>" onfocus="if (this.value == '<%=itemprice%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=itemprice%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Item's Des</label>
                                    <span><%=message6%></span>
                                    <input type="text" name="itemdes" value="<%=itemdes%>" onfocus="if (this.value == '<%=itemdes%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=itemdes%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Item's IMG</label>
                                    <span><%=message7%></span>
                                    <input type="text" name="itemimg" value="<%=itemimg%>" onfocus="if (this.value == '<%=itemimg%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=itemimg%>';
                                                    }">
                                </p>


                            </div>
                        </div>
                    </div>
                    <div class="clear"></div>
                </div>
            </div>
        </form>
    </body>
</html>
