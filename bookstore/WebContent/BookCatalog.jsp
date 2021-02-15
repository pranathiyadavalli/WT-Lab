<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  
<%@ page import="java.util.List" %>
            <%@ page import="com.dto.Book" %>
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
            List<Book> listBook = bookDAO.listAllBooks();
            pageContext.setAttribute("listBook", listBook);
            
            %>
            
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <h3>Hi, ${userName}</h3>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
               
            </tr>
      
            
            <c:forEach items="${listBook}" var="book" >
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td><a href="CartServlet?book=${book.id }">Add To Cart</a>
                     </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>