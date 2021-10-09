<%-- 
    Document   : adduser
    Created on : Dec 19, 2020, 2:50:11 PM
    Author     : memft
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <title>Add user</title>
    </head>
    <body>
        <% String message5 = (String) request.getAttribute("message5");
            if (message5 == null) {
                message5 = "";
            }
            String message3 = (String) request.getAttribute("message3");
            if (message3 == null) {
                message3 = "";
            }
            String message1 = (String) request.getAttribute("message1");
            if (message1 == null) {
                message1 = "";
            }
            String message2 = (String) request.getAttribute("message2");
            if (message2 == null) {
                message2 = "";
            }
            String message4 = (String) request.getAttribute("message4");
            if (message4 == null) {
                message4 = "";
            }
            String message6 = (String) request.getAttribute("message6");
            if (message6 == null) {
                message6 = "";
            }
            String message7 = (String) request.getAttribute("message7");
            if (message7 == null) {
                message7 = "";
            }
            String message8 = (String) request.getAttribute("message8");
            if (message8 == null) {
                message8 = "";
            }
            String message9 = (String) request.getAttribute("message9");
            if (message9 == null) {
                message9 = "";
            }

        %>
        <div class="register_account">
            <div class="wrap">
                <p>
                <h4 class="title">Create an Account</h4>
                <span style="color:red;font-style:italic;"><%=message5%></span>
                <span style="color:red;font-style:italic;"><%=message1%></span>
                <span style="color:red;font-style:italic;"><%=message2%></span>
                <span style="color:red;font-style:italic;"><%=message3%></span>
                <span style="color:red;font-style:italic;"><%=message4%></span>
                <br>
                <span style="color:red;font-style:italic;"><%=message6%></span>
                <span style="color:red;font-style:italic;"><%=message7%></span>
                <span style="color:red;font-style:italic;"><%=message8%></span>
                <span style="color:red;font-style:italic;"><%=message9%></span>

                </p>
                <form action="insertinfo?action=admin" method="post">
                    <%%>
                    <div class="col_1_of_2 span_1_of_2">
                        <div><input type="text" name="username" value="Username" onfocus="if (this.value == 'Username') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Username';
                                        }"></div>
                        <div><input type="text" name="showname" value="Show name" onfocus="if (this.value == 'Show name') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Show name';
                                        }"></div>
                        <div><input type="text" name="email" value="E-Mail" onfocus="if (this.value == 'E-Mail') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'E-Mail';
                                        }"></div>

                        <div><input type="text" name="password" value="Password" onfocus="if (this.value == 'Password') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Password';
                                        }"></div>
                    </div>
                    <div class="col_1_of_2 span_1_of_2">	
                        <div><input type="text" name="address" value="Address" onfocus="if (this.value == 'Address') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Address';
                                        }"></div>

                        <div><input type="text" value="District" name="country" onfocus="if (this.value == 'District') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'District';
                                        }"></div>

                        <div><input type="text" name="city" value="City" onfocus="if (this.value == 'City') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                    this.value = 'City';
                                }"></div>
                        <div> <input type="text" name="phone" value="Phone Number" class="number" onfocus="if (this.value == 'Phone Number') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                    this.value = 'Phone Number';
                                }"></div>
                        <div> <input type="text" name="level" value="Level" class="number" onfocus="if (this.value == 'Level') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                    this.value = '0';
                                }"></div>
                        <!--		          	 <p class="code"></p>-->
                    </div>
                    <button type="submit" class="grey">Submit</button>

                    
                    <div class="clear"></div>
                </form>
            </div> 
        </div>
    </body>
</html>
