<%-- 
    Document   : login
    Created on : Nov 2, 2018, 12:14:25 AM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>doTest - Login</title>
        <link rel="stylesheet" type="text/css" href="./css/login.css">
    </head>
    <body>
        <div class="container-login">
        <div class="div-logo">
            <a href="#"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
        </div>
        <div class="main-login">
            <div class="lg-left">
                <p>Login</p>
                <form method="POST" action="login">
                    <p>Username:</p>
                    <input type="text" placeholder="Enter username here" name="username"/>
                    <p>Password:</p>
                    <input type="password" placeholder="Enter password here" name="password"/>
                    <input type="submit" value="Login"/>
                </form>
                <c:if test="${fault == 'incorrect'}">
                    <p id="lg-fault">&times; Incorrect username or password.</p>
                </c:if>
                <c:if test="${fault == 'user not found'}">
                    <p id="lg-fault">&times; User not found.</p>
                </c:if>
                <a href="register">Don't you have any account?</a>
            </div>
            <div class="lg-right">
                <p>About doTest?</p>
                <ul>
                    <li>doTest is a test generator that sports 4 question types, automatic grading. </li>
                    <li>doTest is a really simple interface and detailed reports.</li>
                    <li>doTest is totally free.</li>
                </ul>
            </div>
            <div class="fix-float"></div>
        </div>
        <div class="footer">
            <p>doTest company.</p>
            <p>&copy; Copyright 2018. All rights reserved. </p>
        </div>
    </div>    
    </body>
</html>
