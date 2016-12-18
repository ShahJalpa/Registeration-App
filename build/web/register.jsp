<%-- 
    Document   : register
    Created on : Nov 17, 2015, 5:13:19 AM
    Author     : jalpa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Maya Dance Academy</title>
    </head>
    <body>
        <h2>Please fill the information below to register.</h2>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
        
        <!--<p><%--${message}--%></p>-->
        
        <p><c:out value="${message}"/></p>
        
        
        <form action="RegisterationServlet" method="post">
            <input type="hidden" name="action" value="add">
            <table>
            <tr>
                <td>First Name</td>
               <!-- <td><input type="text" name="firstName" value="<%--${user.firstName}--%>"/></td>-->
                <td><input type="text" name="firstName" value="<c:out value='${user.firstName}'/>"></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <!--<td><input type="text" name="lastName" value="<%--${user.lastName}--%>"/></td>-->
                <td><input type="text" name="lastName" value="<c:out value='${user.lastName}'/>"></td>
            </tr>
            <tr>
                <td>Email</td>
                <!--<td><input type="email" name="email" value="<%--${user.email}--%>"/></td>-->
                <td><input type="email" name="email" value="<c:out value='${user.email}'/>"></td>
            </tr>
            <tr>
                <td>User Name</td>
                <!--<td><input type="text" name="userName" value="<%--${user.userName}--%>"/></td>-->
                <td><input type="text" name="userName" value="<c:out value='${user.userName}'/>"></td>
            </tr>
            <tr>
                <td>Password</td>
                <!--<td><input type="password" name="passWord" value="<%--${user.passWord}--%>"/></td>-->
                <td><input type="password" name="passWord" value="<c:out value='${user.passWord}'/>"></td>
            </tr>
        </table>
        <br>
        <input type="submit" name="action" value="submit">
        </form>
        <br>
        <p>Already registered. Please click on <a href="signIn.jsp">Sign in</a>.</p>
    </body>
</html>
