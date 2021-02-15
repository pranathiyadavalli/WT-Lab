package com.py;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;  

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		String username = context.getInitParameter("username");
		String password = context.getInitParameter("password");
		
		String user_name = request.getParameter("username");
		String pass_word = request.getParameter("password");
		System.out.println(user_name);
		System.out.println(pass_word);
	
		
		HttpSession session = request.getSession(true);

		
		if(user_name.equals(username) && pass_word.equals(password)) {
			
			session.setAttribute("username", request.getParameter("username"));
			 RequestDispatcher rd = request.getRequestDispatcher("catalog.html");
		//request.getRequestDispatcher("homepage.html").forward(request,response);  
		//out.println(request.getAttribute("username"));
			 
			 //out.println("Hi,"+username);
		 rd.include(request, response); 
		}
		else {
		
		session.invalidate();
        request.setAttribute("errorMessage", "Invalid user or password");
        //out.println(request.getAttribute("errorMessage"));
        out.println("<h1 style='margin-left: 533px;\r\n" + 
        		"    margin-top: 70px;\r\n" + 
        		"    font color: red;\r\n" + 
        		"    color: crimson;'>Invalid username or password</h1>");
        RequestDispatcher rd = request.getRequestDispatcher("login.html");
        rd.include(request, response); 
		
		out.close();
		}
		
	}

}
