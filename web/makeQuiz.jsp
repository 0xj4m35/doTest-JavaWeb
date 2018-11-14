<%-- 
    Document   : makeQuiz
    Created on : Nov 13, 2018, 10:39:27 PM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz</title>
        <link rel="stylesheet" type="text/css" href="./css/makeQuiz.css">
    </head>
    <body>

        <div class="container-login">
            <div class="div-logo">
                <a href="home"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
            </div>
            <div class="main-login">
                <p class="form-title">Make Quiz</p>
                <form action="makequiz" method="POST">
                    <table cellspacing="7">
                        <tr>
                            <td>Title:</td>
                            <td><input type="text" name="title"/></td>
                        </tr>
                        <tr>
                            <td>Subject:</td>
                            <td><select name="subject">
                                    <c:forEach items="${subs}" var="sub">
                                        <option value="${sub.subjectId}" >${sub.subjectName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Total Questions:</td>
                            <td><input type="text" name="totalQues"/></td>
                        </tr>
                        <tr>
                            <td>Link Quiz will be:</td>
                            <td><a href="quiz?quizId=${newQuizId}">http://localhost:8080/doTest/quiz?quizId=${newQuizId}</a></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Make a quiz" /></td>
                        </tr>
                    </table>
                </form> 
            </div>
            <div class="footer">
                <p>doTest company.</p>
                <p>&copy; Copyright 2018. All rights reserved. </p>
            </div>
        </div> 
    </body>
</html>
