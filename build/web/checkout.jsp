<%-- 
    Document   : checkout
    Created on : Dec 3, 2020, 11:00:21 PM
    Author     : memft
--%>

<%@page import="model.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
    <head>
        <title>HCMUTE's Project</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/styletest.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <!--        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>-->
        <script type="text/javascript">
            $(document).ready(function() {
                $(".dropdown img.flag").addClass("flagvisibility");
                $(".dropdown dt a").click(function() {
                    $(".dropdown dd ul").toggle();
                });
                $(".dropdown dd ul li a").click(function() {
                    var text = $(this).jsp();
                    $(".dropdown dt a span").jsp(text);
                    $(".dropdown dd ul").hide();
                    $("#result").jsp("Selected value is: " + getSelectedValue("sample"));
                });
                function getSelectedValue(id) {
                    return $("#" + id).find("dt a span.value").jsp();
                }

                $(document).bind('click', function(e) {
                    var $clicked = $(e.target);
                    if (!$clicked.parents().hasClass("dropdown"))
                        $(".dropdown dd ul").hide();
                });
                $("#flagSwitcher").click(function() {
                    $(".dropdown img.flag").toggleClass("flagvisibility");
                });
            });</script>
        <!-- start menu -->     
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function() {
                $(".megamenu").megamenu();
            });</script>
        <!-- end menu -->
        <!-- top scrolling -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function($) {
                $(".scroll").click(function(event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
                });
            });</script>
    </head>
    <body>
        <div class="header-top">
            <div class="wrap"> 
                <div class="logo">
                    <!--<a href="index.jsp"><img src="images/logo1.png" alt="" width="345px" height="107px"/></a>-->
                    <a href="index.jsp"><img src="images/logo5.png" alt=""/></a>
                </div>
                <div class="cssmenu">
                    <ul>
                        <li class="active"><a href="register.jsp">Sign up & Save</a></li> 
                        <li><a href="loaditem">Store Locator</a></li> 
                        <li><a href="login.jsp">My Account</a></li> 
                        <li><a href="addtocart?action=null">CheckOut</a></li> 
                    </ul>
                </div>
                <ul class="icon2 sub-icon2 profile_img">
                    <li><a class="active-icon c2" href="#"> </a>
                        <ul class="sub-icon2 list">
                            <li><h3>Project Web</h3><a href=""></a></li>
                            <li><p>Vo Thanh Cong Danh - 18110088</p></li>
                            <li><p>Dam Tuong Vy - 18110242</p></li>
                            <li><p>Tran Vo Buu Dien - 18110096</p></li>
                        </ul>
                    </li>
                </ul>
                <div class="clear"></div>
            </div>
        </div>
        <div class="header-bottom">
            <div class="wrap">
                <!-- start header menu -->
                <!--		<ul class="megamenu skyblue">
                                    <li><a class="color1" href="#">Home</a></li>
                                        <li class="grid"><a class="color2" href="#">Men</a>
                                                <div class="megapanel">
                                                        <div class="row">
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>popular</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">login</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                        <div class="h_nav">
                                                                                <h4 class="top">men</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>style zone</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <img src="images/nav_img.jpg" alt=""/>
                                                        </div>
                                                </div>
                                                </li>
                                           <li class="active grid"><a class="color4" href="#">Women</a>
                                                <div class="megapanel">
                                                        <div class="row">
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>shop</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>help</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>my company</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>												
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>account</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">login</a></li>
                                                                                        <li><a href="shop.html">create an account</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                        <li><a href="shop.html">my shopping bag</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                </ul>	
                                                                        </div>						
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>popular</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                                <div class="col1">
                                                                 <div class="h_nav">
                                                                   <img src="images/nav_img1.jpg" alt=""/>
                                                                 </div>
                                                                </div>
                                                        </div>
                                                        <div class="row">
                                                                <div class="col2"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                        </div>
                                                        </div>
                                        </li>				
                                                <li><a class="color5" href="#">Kids</a>
                                                <div class="megapanel">
                                                        <div class="row">
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>popular</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">login</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                        <div class="h_nav">
                                                                                <h4 class="top">man</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>style zone</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <img src="images/nav_img2.jpg" alt=""/>
                                                        </div>
                                                </div>
                                                </li>
                                                <li><a class="color6" href="#">Sale</a>
                                                <div class="megapanel">
                                                        <div class="row">
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>shop</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                </ul>	
                                                                        </div>	
                                                                        <div class="h_nav">
                                                                                <h4 class="top">my company</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>												
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>man</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>						
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>help</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>account</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">login</a></li>
                                                                                        <li><a href="shop.html">create an account</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                        <li><a href="shop.html">my shopping bag</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                </ul>	
                                                                        </div>						
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>my company</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>popular</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                        </div>
                                                        <div class="row">
                                                                <div class="col2"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                        </div>
                                                </div>
                                                </li>
                                                <li><a class="color7" href="#">Customize</a>
                                                <div class="megapanel">
                                                        <div class="row">
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>shop</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>help</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>my company</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>												
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>account</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">login</a></li>
                                                                                        <li><a href="shop.html">create an account</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                        <li><a href="shop.html">my shopping bag</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                </ul>	
                                                                        </div>						
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>my company</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>popular</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                        </div>
                                                        <div class="row">
                                                                <div class="col2"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                        </div>
                                                </div>
                                                </li>
                                                <li><a class="color8" href="#">Shop</a>
                                                <div class="megapanel">
                                                        <div class="row">
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>style zone</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>popular</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">login</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                        <div class="h_nav">
                                                                                <h4 class="top">man</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                        </div>
                                                </div>
                                                </li>
                                                <li><a class="color9" href="#">Football</a>
                                                <div class="megapanel">
                                                        <div class="row">
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>shop</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>help</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>							
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>my company</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>												
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>account</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">login</a></li>
                                                                                        <li><a href="shop.html">create an account</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                        <li><a href="shop.html">my shopping bag</a></li>
                                                                                        <li><a href="shop.html">brands</a></li>
                                                                                        <li><a href="shop.html">create wishlist</a></li>
                                                                                </ul>	
                                                                        </div>						
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>my company</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">trends</a></li>
                                                                                        <li><a href="shop.html">sale</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                                <div class="col1">
                                                                        <div class="h_nav">
                                                                                <h4>popular</h4>
                                                                                <ul>
                                                                                        <li><a href="shop.html">new arrivals</a></li>
                                                                                        <li><a href="shop.html">men</a></li>
                                                                                        <li><a href="shop.html">women</a></li>
                                                                                        <li><a href="shop.html">accessories</a></li>
                                                                                        <li><a href="shop.html">kids</a></li>
                                                                                        <li><a href="shop.html">style videos</a></li>
                                                                                </ul>	
                                                                        </div>
                                                                </div>
                                                        </div>
                                                        <div class="row">
                                                                <div class="col2"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                                <div class="col1"></div>
                                                        </div>
                                                </div>
                                                </li>
                                                <li><a class="color10" href="#">Running</a></li>
                                                <li><a class="color11" href="#">Originals</a></li>
                                                <li><a class="color12" href="#">Basketball</a></li>
                                   </ul>
                                   <div class="clear"></div>-->
            </div>
        </div>
        <% if (session.getAttribute("user") == null) { %>
        <div class="login">
            <div class="wrap">
                <h4 class="title">You must log in first to purchase items.</h4>
                <p class="cart">You can sign up if you don't already have an account.<br>Click<a href="register.jsp"> here</a> to sign up</p>
            </div>
            <% } else {
                User user = (User) session.getAttribute("user");
                String username = user.getUserName();
                List<Cart> listCart = (List<Cart>) session.getAttribute("cart");
                String msg = (String) request.getAttribute("msg");
                if (msg == null) {
                    msg = "";
                }


            %>
            <!--            <div class="slider-right">
                            <h1>Shopping Cart</h1></div>-->
            <div class="shopping-cart">
                <div class="wrap">
                    <h4 class="title"><%=msg%></h4>
                </div>
                <div class="column-labels">
                    <label class="product-image"></label>
                    <label class="product-details"></label>
                    <label class="product-price"></label>
                    <label class="product-quantity"></label>
                    <label class="product-removal"></label>
                    <label class="product-line-price"></label>
                </div>
                <%                    float sum = 0;
                    float total = 0;
                    if (listCart != null) {
                        for (Cart cart : listCart) {
                            if (username.equals(cart.getUserId())) {
                                List<Product> items = (List<Product>) request.getAttribute("listProduct");
                                if (items != null) {
                                    for (Product product : items) {
                                        if (product.getItemId().equals(cart.getItemId())) {
                                            String itemimg = product.getItemImg();
                                            String itemdes = product.getItemDes();
                                            String itemname = product.getItemName();
                                            int itemstock = product.getItemStock();
                                            float itemprice = product.getItemPrice();
                                            String itemid = product.getItemId();
                                            int itemquantity = cart.getQuantity();
                                            sum = (((float) Math.round((itemprice * itemquantity) * 100) / 100));

                                            total = (((float) Math.round((total + sum) * 100) / 100));

                %>
                <div class="product">
                    <div class="product-image">
                        <img src="<%=itemimg%>">
                    </div>
                    <div class="product-details">
                        <div class="product-title"><%=itemname%></div>
                        <p class="product-description"><%=itemdes%></p>
                        <p class="product-description">Stock : <%=itemstock%></p>
                    </div>
                    <div class="product-price"><%=itemprice%></div>
                    <div class="product-quantity">
                        <input type="number" value="<%=itemquantity%>" min="1" onchange="EditCart(this.value,<%=itemid%>)">
                    </div>
                    <div class="product-removal">
                        <button class="remove-product" onclick="DelCart(<%=itemid%>)">
                            Remove
                        </button>
                    </div>
                    <div class="product-line-price"><%=sum%></div>
                </div>
                <% }

                                    }

                                }
                            }

                        }
                    }
                    float tax = (((float) Math.round(((total * 5) / 100) * 100) / 100));
                    float shipping = 15;
                    float grandtotal = (((float) Math.round((total + tax + shipping) * 100) / 100));
                %>

                <div class="totals">
                    <div class="totals-item">
                        <label>Subtotal</label>
                        <div class="totals-value" id="cart-subtotal"><%=total%></div>
                    </div>
                    <div class="totals-item">
                        <label>Tax (5%)</label>
                        <div class="totals-value" id="cart-tax"><%=tax%></div>
                    </div>
                    <div class="totals-item">
                        <label>Shipping</label>
                        <div class="totals-value" id="cart-shipping"><%=shipping%></div>
                    </div>
                    <div class="totals-item totals-item-total">
                        <label>Grand Total</label>
                        <div class="totals-value" id="cart-total"><%=grandtotal%></div>
                    </div>
                </div>

                <button class="checkout" onclick="window.open('purchase?total=<%=grandtotal%>', '_self')">Purchase</button>

            </div>
            <% }%>
        </div>
        <div class="footer">
            <div class="footer-top">
                <div class="wrap">
                    <!--       			   <div class="col_1_of_footer-top span_1_of_footer-top">
                                                             <ul class="f_list">
                                                                    <li><img src="images/f_icon.png" alt=""/><span class="delivery">Free delivery on all orders over ??100*</span></li>
                                                             </ul>
                                                       </div>
                                                       <div class="col_1_of_footer-top span_1_of_footer-top">
                                                            <ul class="f_list">
                                                                    <li><img src="images/f_icon1.png" alt=""/><span class="delivery">Customer Service :<span class="orange"> (800) 000-2587 (freephone)</span></span></li>
                                                             </ul>
                                                       </div>
                                                       <div class="col_1_of_footer-top span_1_of_footer-top">
                                                            <ul class="f_list">
                                                                    <li><img src="images/f_icon2.png" alt=""/><span class="delivery">Fast delivery & free returns</span></li>
                                                             </ul>
                                                       </div>
                                                      <div class="clear"></div>-->
                </div>
            </div>
            <div class="footer-middle">
                <div class="wrap">
                    <div class="section group">
                        <div class="col_1_of_middle span_1_of_middle">
                            <!--					<dl id="sample" class="dropdown">
                                                            <dt><a href="#"><span>Please Select a Country</span></a></dt>
                                                            <dd>
                                                                <ul>
                                                                    <li><a href="#">Australia<img class="flag" src="images/as.png" alt="" /><span class="value">AS</span></a></li>
                                                                    <li><a href="#">Sri Lanka<img class="flag" src="images/srl.png" alt="" /><span class="value">SL</span></a></li>
                                                                    <li><a href="#">Newziland<img class="flag" src="images/nz.png" alt="" /><span class="value">NZ</span></a></li>
                                                                    <li><a href="#">Pakistan<img class="flag" src="images/pk.png" alt="" /><span class="value">Pk</span></a></li>
                                                                    <li><a href="#">United Kingdom<img class="flag" src="images/uk.png" alt="" /><span class="value">UK</span></a></li>
                                                                    <li><a href="#">United States<img class="flag" src="images/us.png" alt="" /><span class="value">US</span></a></li>
                                                                </ul>
                                                             </dd>
                                                                </dl>-->
                        </div>
                        <div class="col_1_of_middle span_1_of_middle">
                            <ul class="f_list1">
                                <li><span class="m_8">Sign up for email and Get 15% off</span>
                                    <div class="search">	  
                                        <input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                    this.value = 'Search';
                                                }">
                                        <input type="submit" value="Subscribe" id="submit" name="submit">
                                        <div id="response"> </div>
                                    </div><div class="clear"></div>
                                </li>
                            </ul>
                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
            <div class="footer-bottom">
                <div class="wrap">
                    <!--       	 		<div class="section group">
                                                    <div class="col_1_of_5 span_1_of_5">
                                                            <h3 class="m_9">Shop</h3>
                                                            <ul class="sub_list">
                                                                    <h4 class="m_10">Men</h4>
                                                                <li><a href="shop.html">Men's Shoes</a></li>
                                                        <li><a href="shop.html">Men's Clothing</a></li>
                                                        <li><a href="shop.html">Men's Accessories</a></li>
                                                    </ul>
                                                         <ul class="sub_list">
                                                                <h4 class="m_10">Women</h4>
                                                                <li><a href="shop.html">Women's Shoes</a></li>
                                                                <li><a href="shop.html">Women's Clothing</a></li>
                                                                <li><a href="shop.html">Women's Accessories</a></li>
                                                             </ul>
                                                             <ul class="sub_list">
                                                                <h4 class="m_10">Kids</h4>
                                                                <li><a href="shop.html">Kids Shoes</a></li>
                                                                <li><a href="shop.html">Kids Clothing</a></li>
                                                                <li><a href="shop.html">Kids Accessories</a></li>
                                                             </ul>
                                                            <ul class="sub_list">
                                                                <h4 class="m_10">style</h4>
                                                                <li><a href="shop.html">Porsche Design Sport</a></li>
                                                                <li><a href="shop.html">Porsche Design Shoes</a></li>
                                                                <li><a href="shop.html">Porsche Design Clothing</a></li>
                                                            </ul>
                                                            <ul class="sub_list">
                                                                <h4 class="m_10">Adidas Neo Label</h4>
                                                                <li><a href="shop.html">Adidas NEO Shoes</a></li>
                                                                <li><a href="shop.html">Adidas NEO Clothing</a></li>
                                                            </ul>
                                                            <ul class="sub_list1">
                                                                <h4 class="m_10">Customise</h4>
                                                                <li><a href="shop.html">mi adidas</a></li>
                                                                <li><a href="shop.html">mi team</a></li>
                                                                <li><a href="shop.html">new arrivals</a></li>
                                                            </ul>
                                                    </div>
                                                    <div class="col_1_of_5 span_1_of_5">
                                                            <h3 class="m_9">Sports</h3>
                                                            <ul class="list1">
                                                                <li><a href="shop.html">Basketball</a></li>
                                                        <li><a href="shop.html">Football</a></li>
                                                        <li><a href="shop.html">Football Boots</a></li>
                                                        <li><a href="shop.html">Predator</a></li>
                                                        <li><a href="shop.html">F50</a></li>
                                                        <li><a href="shop.html">Football Clothing</a></li>
                                                        <li><a href="shop.html">Golf</a></li>
                                                        <li><a href="shop.html">Golf Shoes</a></li>
                                                        <li><a href="shop.html">Golf Clothing</a></li>
                                                        <li><a href="shop.html">Outdoor</a></li>
                                                        <li><a href="shop.html">Outdoor Shoes</a></li>
                                                        <li><a href="shop.html">Outdoor Clothing</a></li>
                                                        <li><a href="shop.html">Rugby</a></li>
                                                        <li><a href="shop.html">Running</a></li>
                                                        <li><a href="shop.html">Running Shoes</a></li>
                                                        <li><a href="shop.html">Boost</a></li>
                                                        <li><a href="shop.html">Supernova</a></li>
                                                        <li><a href="shop.html">Running Clothing</a></li>
                                                        <li><a href="shop.html">Swimming</a></li>
                                                        <li><a href="shop.html">Tennis</a></li>
                                                        <li><a href="shop.html">Tennis Shoes</a></li>
                                                        <li><a href="shop.html">Tennis Clothing</a></li>
                                                        <li><a href="shop.html">Training</a></li>
                                                        <li><a href="shop.html">Training Shoes</a></li>
                                                        <li><a href="shop.html">Training Clothing</a></li>
                                                        <li><a href="shop.html">Training Accessories</a></li>
                                                        <li><a href="shop.html">miCoach</a></li>
                                                        <li><a href="shop.html">All Sports</a></li>
                                                     </ul>
                                                    </div>
                                                    <div class="col_1_of_5 span_1_of_5">
                                                            <h3 class="m_9">Originals</h3>
                                                            <ul class="list1">
                                                                <li><a href="shop.html">Originals Shoes</a></li>
                                                        <li><a href="shop.html">Gazelle</a></li>
                                                        <li><a href="shop.html">Samba</a></li>
                                                        <li><a href="shop.html">LA Trainer</a></li>
                                                        <li><a href="shop.html">Superstar</a></li>
                                                        <li><a href="shop.html">SL</a></li>
                                                        <li><a href="shop.html">ZX</a></li>
                                                        <li><a href="shop.html">Campus</a></li>
                                                        <li><a href="shop.html">Spezial</a></li>
                                                        <li><a href="shop.html">Dragon</a></li>
                                                        <li><a href="shop.html">Originals Clothing</a></li>
                                                        <li><a href="shop.html">Firebird</a></li>
                                                        <li><a href="shop.html">Originals Accessories</a></li>
                                                        <li><a href="shop.html">Men's Originals</a></li>
                                                        <li><a href="shop.html">Women's Originals</a></li>
                                                        <li><a href="shop.html">Kid's Originals</a></li>
                                                        <li><a href="shop.html">All Originals</a></li>
                                                </ul>
                                                    </div>
                                                    <div class="col_1_of_5 span_1_of_5">
                                                            <h3 class="m_9">Product Types</h3>
                                                            <ul class="list1">
                                                                <li><a href="shop.html">Shirts</a></li>
                                                                <li><a href="shop.html">Pants & Tights</a></li>
                                                                <li><a href="shop.html">Shirts</a></li>
                                                                <li><a href="shop.html">Jerseys</a></li>
                                                                <li><a href="shop.html">Hoodies & Track Tops</a></li>
                                                                <li><a href="shop.html">Bags</a></li>
                                                                <li><a href="shop.html">Jackets</a></li>
                                                                <li><a href="shop.html">Hi Tops</a></li>
                                                                <li><a href="shop.html">SweatShirts</a></li>
                                                                <li><a href="shop.html">Socks</a></li>
                                                                <li><a href="shop.html">Swimwear</a></li>
                                                                <li><a href="shop.html">Tracksuits</a></li>
                                                                <li><a href="shop.html">Hats</a></li>
                                                                <li><a href="shop.html">Football Boots</a></li>
                                                                <li><a href="shop.html">Other Accessories</a></li>
                                                                <li><a href="shop.html">Sandals & Flip Flops</a></li>
                                                                <li><a href="shop.html">Skirts & Dresseses</a></li>
                                                                <li><a href="shop.html">Balls</a></li>
                                                                <li><a href="shop.html">Watches</a></li>
                                                                <li><a href="shop.html">Fitness Equipment</a></li>
                                                                <li><a href="shop.html">Eyewear</a></li>
                                                                <li><a href="shop.html">Gloves</a></li>
                                                                <li><a href="shop.html">Sports Bras</a></li>
                                                                <li><a href="shop.html">Scarves</a></li>
                                                                <li><a href="shop.html">Shinguards</a></li>
                                                                <li><a href="shop.html">Underwear</a></li>
                                                </ul>
                                                    </div>
                                                    <div class="col_1_of_5 span_1_of_5">
                                                            <h3 class="m_9">Support</h3>
                                                            <ul class="list1">
                                                               <li><a href="shop.html">Store finder</a></li>
                                                               <li><a href="shop.html">Customer Service</a></li>
                                                               <li><a href="shop.html">FAQ</a></li>
                                                               <li><a href="shop.html">Online Shop Contact Us</a></li>
                                                               <li><a href="shop.html">about adidas Products</a></li>
                                                               <li><a href="shop.html">Size Charts </a></li>
                                                               <li><a href="shop.html">Ordering </a></li>
                                                               <li><a href="shop.html">Payment </a></li>
                                                               <li><a href="shop.html">Shipping </a></li>
                                                               <li><a href="shop.html">Returning</a></li>
                                                               <li><a href="shop.html">Using out Site</a></li>
                                                               <li><a href="shop.html">Delivery Terms</a></li>
                                                               <li><a href="shop.html">Site Map</a></li>
                                                               <li><a href="shop.html">Gift Card</a></li>
                                                              
                                                </ul>
                                                <ul class="sub_list2">
                                                   <h4 class="m_10">Company Info</h4>
                                                       <li><a href="shop.html">About Us</a></li>
                                                       <li><a href="shop.html">Careers</a></li>
                                                       <li><a href="shop.html">Press</a></li>
                                                    </ul>
                                                    </div>
                                                    <div class="clear"></div>
                                            </div>-->
                    <div class="map" >
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1959.2482098416972!2d106.77023816191623!3d10.849796889321453!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527a03a6378c5%3A0xb4a838949a4175c8!2zMSBWw7UgVsSDbiBOZ8OibiwgTGluaCBDaGnhu4N1LCBUaOG7pyDEkOG7qWMsIFRow6BuaCBwaOG7kSBI4buTIENow60gTWluaCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1605515488600!5m2!1svi!2s" width="auto" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                    </div>
                </div>
            </div>
            <div class="copy">
                <div class="wrap">
                    <p>?? All rights reserved | Template by&nbsp;<a href="http://w3layouts.com/"> W3Layouts</a></p>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function() {

                var defaults = {
                    containerID: 'toTop', // fading element id
                    containerHoverID: 'toTopHover', // fading element hover id
                    scrollSpeed: 1200,
                    easingType: 'linear'
                };
                $().UItoTop({easingType: 'easeOutQuart'});
            });</script>
        <script type="text/javascript">
            /* Set rates + misc */
            var taxRate = 0.05;
            var shippingRate = 15.00;
            var fadeTime = 300;
            /* Assign actions */
            $('.product-quantity input').change(function() {
                updateQuantity(this);
            });
            $('.product-removal button').click(function() {
                removeItem(this);
            });
            /* Recalculate cart */
            function recalculateCart()
            {
                var subtotal = 0;
                /* Sum up row totals */
                $('.product').each(function() {
                    subtotal += parseFloat($(this).children('.product-line-price').text());
                });
                /* Calculate totals */
                var tax = subtotal * taxRate;
                var shipping = (subtotal > 0 ? shippingRate : 0);
                var total = subtotal + tax + shipping;
                /* Update totals display */
                $('.totals-value').fadeOut(fadeTime, function() {
                    $('#cart-subtotal').html(subtotal.toFixed(2));
                    $('#cart-tax').html(tax.toFixed(2));
                    $('#cart-shipping').html(shipping.toFixed(2));
                    $('#cart-total').html(total.toFixed(2));
                    if (total == 0) {
                        $('.checkout').fadeOut(fadeTime);
                    } else {
                        $('.checkout').fadeIn(fadeTime);
                    }
                    $('.totals-value').fadeIn(fadeTime);
                });
            }


            /* Update quantity */
            function updateQuantity(quantityInput)
            {
                /* Calculate line price */
                var productRow = $(quantityInput).parent().parent();
                var price = parseFloat(productRow.children('.product-price').text());
                var quantity = $(quantityInput).val();
                var linePrice = price * quantity;
                /* Update line price display and recalc cart totals */
                productRow.children('.product-line-price').each(function() {
                    $(this).fadeOut(fadeTime, function() {
                        $(this).text(linePrice.toFixed(2));
                        recalculateCart();
                        $(this).fadeIn(fadeTime);
                    });
                });
            }


            /* Remove item from cart */
            function removeItem(removeButton)
            {
                /* Remove row from DOM and recalc cart total */
                var productRow = $(removeButton).parent().parent();
                productRow.slideUp(fadeTime, function() {
                    productRow.remove();
                    recalculateCart();
                });
            }

        </script>
        <script>
            function EditCart(val, itemidchange)
            {

                window.open('editcart?quantity=' + val + '&itemidchange=' + itemidchange + '', '_self');
            }
            function DelCart(itemidchange)
            {

                window.open('delcart?itemidchange=' + itemidchange + '', '_self');
            }

        </script>

        <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>       
    </body>
</html>
