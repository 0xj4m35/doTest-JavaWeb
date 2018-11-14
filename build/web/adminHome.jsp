<%-- 
    Document   : adminHome
    Created on : Nov 6, 2018, 10:19:08 AM
    Author     : Nguyen Thai Bao
--%>

<%@page import="dal.UserDAO"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>doTest | Administrator</title>
        <link rel="stylesheet" type="text/css" href="./css/adminHome.css">
    </head>
    <body>
        <div class="container-login">
            <div class="div-logo">
                <a href="home"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
            </div>
            <div class="main-login">
                <p class="user">${sessionScope.user.fullname} | <i><a href="logout">Sign out</a></i></p>
                <ul>
                    <li><a href="add">+ Add new Question</a></li>
                    <li><a href="list">+ List all Question</a></li>
                    <li><a href="makequiz">+ Make a Quiz</a></li>
                </ul>
                <p class="table-title">Quizzes</p>
                <table>
                    <tr>
                        <th>Num.</th>
                        <th>Title</th>
                        <th>Total</th>
                        <th>Author</th>
                        <th>Day Created</th>
                    </tr>
                    <c:forEach var="quiz" items="${quizzes}" varStatus="loop">
                        <tr>
                            <td>${loop.index + 1}</td>
                            <td><a href="quiz?quizId=${quiz.quizID}">${quiz.title}</a></td>
                            <td>${quiz.quesNum}</td>
                            <td>${quiz.fullNameOfAuthor}</td>
                            <td><fmt:formatDate type = "date" 
                                            dateStyle = "short" value = "${quiz.dayCreated}" /></td>
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
