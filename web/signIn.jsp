<%-- 
    Document   : signIn
    Created on : Nov 16, 2015, 6:03:39 PM
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
        <h2>Please enter your user name and password to sign in.</h2>
        
        <p>${message}</p>
        
        <form action="SignInServlet" method="POST">
            <label class="pad_top">User Name: </label>
            <input type="text" name="userName" value="${user.userName}"><br>
            <br>
            
            <label class="pad_top">Password: </label>
            <input type="password" name="passWord" value="${user.passWord}"><br>
            <br>
            
            <input type="submit" value="Sign In">
            <input type="reset" value="Reset">
        </form>
        
        <p>Not registered yet? No problem!!</p>
        <p>Please click on Register now. </p>
        
        <form action="register.jsp" method="post">
            <input type="submit" name="action" value="Register Now">
        </form>
    </body>
</html>
