<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form" action="OrderServlet" method="post" >
        <!-- Do not use table to format fields. As a good practice use CSS -->
        <table align="center">
         <tr>
         <td>Credit Card Number</td>
         <td><input type="text" name="credit" /></td>
         </tr>
        
         <tr> <!-- refer to the video to understand request.getAttribute() -->
         <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></span></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Proceed"></input>
         </tr>
        </table>
    </form>

</body>
</html>