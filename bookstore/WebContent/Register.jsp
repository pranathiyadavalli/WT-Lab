<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

</head>
<body>
<div class="topnav">
 
  <a href="Login.jsp">LOGIN</a>
  
</div>
    <form name="form" action="RegisterServlet" method="post" onsubmit="return validate()">
        <table align="center">
         <tr>
         <td>Full Name</td>
         <td><input type="text" name="fullname" /></td>
         </tr>
         <tr>
         <td>Email</td>
         <td><input type="text" name="email" /></td>
         </tr>
         <tr>
         <td>Username</td>
         <td><input type="text" name="username" /></td>
         </tr>
         <tr>
         <td>Credit Card NUmber</td>
         <td><input type="text" name="credit" /></td>
         </tr>
         <td>Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td>Confirm Password</td>
         <td><input type="password" name="conpassword" /></td>
         </tr>
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Register"></input>
         </tr>
        </table>
    </form>
</body>
</html>