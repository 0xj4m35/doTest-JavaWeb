<%-- 
    Document   : listQuestion
    Created on : Nov 12, 2018, 1:23:42 AM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Question</title>
        <link rel="stylesheet" type="text/css" href="./css/listQuestion.css">
    </head>
    <body>

        <div class="container-login">
            <div class="div-logo">
                <a href="home"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
            </div>
            <div class="main-login">
                <p id="form-title">All Questions</p>
                <c:forEach items="${questions}" var="ques" varStatus="loop">
                    <p><b>${loop.index + 1}. ${ques.question}</b></p>
                    <p><i>A. ${ques.correctAnswer}</i></p>
                    <p>B. ${ques.incorrectAnswer1}</p>
                    <p>C. ${ques.incorrectAnswer2}</p>
                    <p>D. ${ques.incorrectAnswer3}</p>
                    <p>&nbsp;</p>
                </c:forEach>
            </div>
            <div class="footer">
                <p>doTest company.</p>
                <p>&copy; Copyright 2018. All rights reserved. </p>
            </div>
        </div>

    </body>
</html>
