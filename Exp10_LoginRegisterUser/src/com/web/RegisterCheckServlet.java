package com.web;


import java.io.IOException;



import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dto.User;


@WebServlet("/RegisterCheckServlet")

public class RegisterCheckServlet extends HttpServlet {

	public RegisterCheckServlet() {
		System.out.println("****RegisterCheckServlet object is created.");
	}
	@Override


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();

		response.setContentType("text/html");
		String username = request.getParameter("username");
		System.out.println(username);
		String fullname = request.getParameter("fullname");
		String password = request.getParameter("password");

		User user = new User(username,fullname,password );
		UserDAO userDAO = new UserDAO();

		int result = userDAO.register(user);

		if(result > 0) {
			out.println("Registered successfully!!!");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);

		}
		else {
			out.println("Registration failed!!!");
			RequestDispatcher rd = request.getRequestDispatcher("register.html");
			rd.include(request, response);

		}

		out.close();
	}
}

