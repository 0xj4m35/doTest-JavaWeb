<%-- 
    Document   : memberHome
    Created on : Nov 5, 2018, 1:07:04 AM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DoTest - Home</title>
        <link rel="stylesheet" type="text/css" href="./css/memberHome.css">
    </head>
    <body>

        <div class="container-login">
            <div class="div-logo">
                <a href="home"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
            </div>
            <div class="main-login">
                <p class="user">${sessionScope.user.fullname} | <i><a href="logout">Sign out</a></i></p>
                <p class="table-title">Done Quizzes</p>
                <table>
                    <tr>
                        <td>Num.</td>
                        <td>Quiz Title</td>
                        <td>Mark</td>
                        <td>Correct</td>
                        <td>Incorrect</td>
                        <td>Day Do Quiz</td>
                    </tr>
                    <c:forEach var="doQuiz" items="${quizzes}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td>${doQuiz.quiz.title}</td>
                            <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${(doQuiz.correct * 10)/(doQuiz.correct + doQuiz.incorrect)}" /></td>
                            <td>${doQuiz.correct}</td>
                            <td>${doQuiz.incorrect}</td>
                            <td><fmt:formatDate type = "date" 
                                            dateStyle = "short" value = "${doQuiz.dayDoQuiz}" /></td>
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
