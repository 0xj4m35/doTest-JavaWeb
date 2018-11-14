<%-- 
    Document   : memDoQuiz
    Created on : Nov 6, 2018, 9:55:19 PM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Members Do Quiz</title>
        <link rel="stylesheet" type="text/css" href="./css/memDoQuiz.css">
    </head>
    <body>

        <div class="container-login">
            <div class="div-logo">
                <a href="home"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
            </div>
            <div class="main-login">
                <p class="table-title">Quiz: <b>${quiz.title}</b></p>
                <table>
                    <tr>
                        <th>Num.</th>
                        <th>Fullname</th>
                        <th>Mark</th>
                        <th>Correct</th>
                        <th>Incorrect</th>
                        <th>Day Do Quiz</th>
                    </tr>
                    <c:forEach var="mem" items="${mems}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${mem.user.fullname}</td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${(mem.correct * 10)/(mem.correct + mem.incorrect)}" /></td>
                            <td>${mem.correct}</td>
                            <td>${mem.incorrect}</td>
                            <td><fmt:formatDate type = "date" 
                                            dateStyle = "short" value = "${mem.dayDoQuiz}" /></td>
                        </tr>

                    </c:forEach>
                </table>
            </div>
            <div class="footer">
                <p>doTest company.</p>
                <p>&copy; Copyright 2018. All rights reserved. </p>
            </div>
        </div>


    </body>
</html>
