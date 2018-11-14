<%-- 
    Document   : register
    Created on : Nov 2, 2018, 10:25:39 AM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>doTest - Register</title>
        <link rel="stylesheet" type="text/css" href="./css/register.css">
    </head>
    <body>
        <div class="container-regis">
        <div class="div-logo">
            <a href="login"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
        </div>
        <div class="main-regis">
            <div class="regis-left">
                <p>Register</p>
                <form method="POST" action="register">
                    <p>Display Name:</p>
                    <input type="text" name="fullname" placeholder="Enter your name here" value="${(fullName!=null)? fullName:""}" />
                    <p>Username:</p>
                    <input type="text" name="username" placeholder="Enter username here" value="${(username!=null)? username:""}"/>
                    <p>Password:</p>
                    <input type="password" name="password" placeholder="Enter password here"/>
                    <p>Re-enter Password:</p>
                    <input type="password" name="repassword" placeholder="Enter password again here"/>
                    <input type="submit" value="Register"/>
                </form>
                <c:if test="${fault != null}">
                    <p id="lg-fault">&times; ${fault == 'blank input' ? "Blank input":""}${fault == 'user existed' ? "Username has been used":""}${fault == 'password invalid' ? "Password is not matched":""}</p>
                </c:if>
                
            </div>
            <div class="regis-right">
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
    </body>
</html>
