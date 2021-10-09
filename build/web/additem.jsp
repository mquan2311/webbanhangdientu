<%-- 
    Document   : additem
    Created on : Dec 21, 2020, 10:38:01 PM
    Author     : memft
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <title>Add item</title>
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
                <span style="color:red;font-style:italic;"><%=message9%></span>
                <span style="color:red;font-style:italic;"><%=message1%></span>
                <span style="color:red;font-style:italic;"><%=message2%></span>
                <span style="color:red;font-style:italic;"><%=message3%></span>
                <span style="color:red;font-style:italic;"><%=message4%></span>
                <br>
                <span style="color:red;font-style:italic;"><%=message6%></span>
                <span style="color:red;font-style:italic;"><%=message7%></span>
                <span style="color:red;font-style:italic;"><%=message5%></span>
                

                </p>
                <form action="insertitem" method="post">
                    <%%>
                    <div class="col_1_of_2 span_1_of_2">
                        <div><input type="text" name="itemid" value="Item ID" onfocus="if (this.value == 'Item ID') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Item ID';
                                        }"></div>
                        <div><input type="text" name="itemname" value="Item name" onfocus="if (this.value == 'Item name') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Item name';
                                        }"></div>
                        <div><input type="text" name="itemstock" value="Item stock" onfocus="if (this.value == 'Item stock') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Item stock';
                                        }"></div>

                       
                    </div>
                    <div class="col_1_of_2 span_1_of_2">	
                        <div><input type="text" name="itemprice" value="Item price" onfocus="if (this.value == 'Item price') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Item price';
                                        }"></div>

                        <div><input type="text" name="itemimg" value="Item image" onfocus="if (this.value == 'Item image') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                            this.value = 'Item image';
                                        }"></div>

                        <div><input type="text" name="itemdes" value="Item decription" onfocus="if (this.value == 'Item decription') {
                                    this.value = '';
                                }" onblur="if (this.value == '') {
                                    this.value = 'Item decription';
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
