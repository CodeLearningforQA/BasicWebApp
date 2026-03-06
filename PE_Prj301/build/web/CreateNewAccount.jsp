<%-- 
    Document   : CreateNewAccount
    Created on : Mar 2, 2026, 7:42:50 AM
    Author     : Be Keo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <h1>Create New Account</h1>
        <form action="MainController" method="POST">
            <c:set var="errors" value="${requestScope.CREATE_ERRORS}"/>
            Username* <input type="text" name="txtUsername" 
                             value="${param.txtUsername}" /> (6 - 20 characters) <br>
            <c:if test="${not empty errors.usernameLengthError}">
                <font color="red">
                ${errors.usernameLengthError}
                </font><br>
            </c:if>
            <c:if test="${not empty errors.usernameIsExister}">
                <font color="red">
                ${errors.usernameIsExister}
                </font><br>
            </c:if>
                
            Password* <input type="password" name="txtPassword" 
                             value="" /> (6 - 20 characters) <br>
            <c:if test="${not empty errors.passwordLengthError}">
                <font color="red">
                ${errors.passwordLengthError}
                </font><br>
            </c:if>
                
            Confirm* <input type="password" name="txtConfirm" 
                            value="" /> <br>
            <c:if test="${not empty errors.confirmMatched}">
                <font color="red">
                ${errors.confirmMatched}
                </font><br>
            </c:if>
                
            Full name* <input type="text" name="txtFullName" 
                              value="${param.txtFullName}" /> (6 - 20 characters) <br>
            <c:if test="${not empty errors.fullNameLengthError}">
                <font color="red">
                ${errors.fullNameLengthError}
                </font><br>
            </c:if>
            <input type="submit" value="Create New Account" name="action" />
            <input type="reset" value="Reset" />

        </form>
    </body>
</html>
