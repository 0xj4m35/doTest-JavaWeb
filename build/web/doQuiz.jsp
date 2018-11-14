<%-- 
    Document   : doQuiz
    Created on : Nov 7, 2018, 12:21:25 AM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Test</title>
        <link rel="stylesheet" type="text/css" href="./css/doQuiz.css">
    </head>
    <body>

        <div class="container-login">
            <div class="div-logo">
                <a href="home"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
            </div>
            <div class="main-login">
                <p id="form-title">${quiz.title}</p>
                <form method="POST" action="quiz">
                    <c:forEach var="ques" items="${questions}" varStatus="loop">
                        <p><b>${loop.index + 1}. ${ques.question}</b></p>
                        <input type="radio" name="ques-${ques.quesId}" value="${ques.correctAnswer}"/> <span> ${ques.correctAnswer} </span> <br/>
                        <input type="radio" name="ques-${ques.quesId}" value="${ques.incorrectAnswer1}"/> <span> ${ques.incorrectAnswer1} </span>  <br/>
                        <input type="radio" name="ques-${ques.quesId}" value="${ques.incorrectAnswer2}"/> <span> ${ques.incorrectAnswer2} </span>  <br/>
                        <input type="radio" name="ques-${ques.quesId}" value="${ques.incorrectAnswer3}"/> <span> ${ques.incorrectAnswer3} </span>  <br/>
                        <p>&nbsp;</p>
                    </c:forEach>
                    <input type="submit" value="Submit"/>   
                </form>
            </div>
            <div class="footer">
                <p>doTest company.</p>
                <p>&copy; Copyright 2018. All rights reserved. </p>
            </div>
        </div>





    </body>
</html>
