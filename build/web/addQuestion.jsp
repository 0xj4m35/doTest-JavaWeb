<%-- 
    Document   : addQuestion
    Created on : Nov 12, 2018, 1:54:06 AM
    Author     : Nguyen Thai Bao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Question</title>
        <link rel="stylesheet" type="text/css" href="./css/addQuestion.css">
    </head>
    <body>

        <div class="container-login">
            <div class="div-logo">
                <a href="home"><img src="./media/dotest.png" alt="logo doTest" width="40%"/></a>
            </div>
            <div class="main-login">
                <p class="form-title">Add New Question</p>
                <form action="add" method="POST">
                    <table cellspacing="7">
                        <tr>
                            <td>Subject:</td>
                            <td><select name="subjectId">
                                    <c:forEach items="${subs}" var="sub">
                                        <option value="${sub.subjectId}">${sub.subjectName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Question:</td>
                            <td><input type="text" name="question" /></td>
                        </tr>
                        <tr>
                            <td>Correct Answer:</td>
                            <td><input type="text" name="corr"/></td>
                        </tr>
                        <tr>
                            <td>Wrong Answer 1:</td>
                            <td><input type="text" name="incorr1"/></td>
                        </tr>
                        <tr>
                            <td>Wrong Answer 2:</td>
                            <td><input type="text" name="incorr2"/></td>
                        </tr>
                        <tr>
                            <td>Wrong Answer 3:</td>
                            <td><input type="text" name="incorr3"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Add New Question"/></td>
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
