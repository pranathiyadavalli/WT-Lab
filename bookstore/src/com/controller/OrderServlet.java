package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.dto.User;


public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
		response.setContentType("text/html");
         String credit = request.getParameter("credit");
         System.out.println(credit + "called");
 		HttpSession session = request.getSession(true); 
 		System.out.println(session.getAttribute("credit"));
        String creditCard = (String) session.getAttribute("credit");
         if(creditCard.equalsIgnoreCase(credit))   {
            out.println("<body text='black'>");
			out.println("<h4><center>Order Success!</center></h4>");
			out.println("</body>");
			request.getRequestDispatcher("/Home.jsp").include(request, response);
         }
         else  
         {
        	 System.out.println("else");
        	 out.println("<body text='red'>");
 			out.println("<h4><center>Invalid Details!</center></h4>");
 			out.println("</body>");
            request.getRequestDispatcher("/Order.jsp").include(request, response);
         }
    }
}
