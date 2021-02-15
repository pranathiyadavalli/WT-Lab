<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  
<%@ page import="java.util.List" %>
            <%@ page import="com.dto.Book" %>
            <%@ page import="com.dto.Cart" %>
            <%@ page import="com.dao.BookDAO" %>
            <%@ page import="com.dao.UserDAO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>

    	<%
            BookDAO bookDAO = new BookDAO();
    	UserDAO userDAO = new UserDAO();
            
            List<Cart> listCart = userDAO.listAll();
            pageContext.setAttribute("listCart", listCart);
            float amount = 0;
            for (Cart cart : listCart) {
            	//out.println(cart.getId() + " " + cart.getBook().getTitle() + "jsp");
            	amount += cart.getBook().getPrice();
            }
            pageContext.setAttribute("amount", amount);
            %>
            
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Cart</h2></caption>
            <tr>
               
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
               
            </tr>
      
            
            <c:forEach items="${listCart}" var="cart" >
                <tr>
                    
                    <td><c:out value="${cart.book.title}" /></td>
                    <td><c:out value="${cart.book.author}" /></td>
                    <td><c:out value="${cart.book.price}" /></td>
                    <td><c:out value="${cart.quantity}" /></td>
                     </tr>
            </c:forEach>
        </table>
        <h3>TOTAL : ${amount }</h3><br><br>
        <form action="Order.jsp">
        <input type="submit" value="Order"></input>
        </form>
    </div>   
</body>
</html>