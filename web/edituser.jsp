<%-- 
    Document   : edituser
    Created on : Dec 18, 2020, 7:45:15 PM
    Author     : memft
--%>

<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit user</title>
    </head>
    <body>
        <%
            String username = (String) request.getParameter("useredit");
            UserDAO userDao = new UserDAO();
            User user = userDao.getProfile(username);

            User usertemp = (User) session.getAttribute("user");
            if (usertemp == null) {
                String redirectURL = "login.jsp?arlet=1";
                response.sendRedirect(redirectURL);
            } else if (usertemp.getLevel() == 0) {
                String redirectURL = "login.jsp?arlet=2";
                response.sendRedirect(redirectURL);
            }

//            HttpSession session = request.getSession();
            session.setAttribute("useredit", user);

            String showname = user.getShowName();
            String address = user.getAddress();
            String email = user.getEmail();
            String phone = user.getPhone();
            String city = user.getCity();
            String country = user.getCountry();
            int level = user.getLevel();

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
            String msg = (String) request.getAttribute("msg");
            if (msg == null) {
                msg = "";
            }


        %>
        <form action="editinfo?act=edit" method="post">
            <div class="login">
                <div class="wrap">

                    <div class="col_1_of_login span_1_of_login">
                        <div class="login-title">
                            <h4 class="title" align="right">User</h4>
                            <div class="comments-area">


                                <p>
                                    <label>Username</label>
                                    <span><%=message2%></span>    
                                    <input type="text" name="username" value="<%=username%>"  onfocus="if (this.value == '<%=username%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=username%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Showname </label>
                                    <span><%=message3%></span>
                                    <input type="text" name="showname" value="<%=showname%>" onfocus="if (this.value == '<%=showname%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=showname%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Phone</label>
                                    <span><%=message4%></span>
                                    <input type="text" name="phone" value="<%=phone%>" onfocus="if (this.value == '<%=phone%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=phone%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Email</label>
                                    <span><%=message5%></span>
                                    <input type="text" name="email" value="<%=email%>" onfocus="if (this.value == '<%=email%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=email%>';
                                                    }">
                                </p>

                                <p>
                                    <span><%=message6%></span>
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
                                    <label>Address</label>
                                    <input type="text" name="address" value="<%=address%>" onfocus="if (this.value == '<%=address%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=address%>';
                                                    }">
                                </p>
                                <p>
                                    <label>City</label>
                                    <input type="text" name="city" value="<%=city%>" onfocus="if (this.value == '<%=city%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=city%>';
                                                    }">
                                </p>
                                <p>
                                    <label>District</label>
                                    <input type="text" name="country" value="<%=country%>" onfocus="if (this.value == '<%=country%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=country%>';
                                                    }">
                                </p>
                                <p>
                                    <label>Level</label>
                                    <span><%=message1%></span>
                                    <input type="text" name="level" value="<%=level%>" onfocus="if (this.value == '<%=level%>') {
                                                this.value = '';
                                            }" onblur="if (this.value == '') {
                                                        this.value = '<%=level%>';
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
