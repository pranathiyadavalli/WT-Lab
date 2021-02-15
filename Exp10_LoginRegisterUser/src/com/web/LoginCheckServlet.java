package com.web;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.dto.User;


@WebServlet("/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session = request.getSession();
		System.out.println("user: "+ username + " pass: " + password);
		UserDAO userdao = new UserDAO();
		User user = userdao.getUserByUsername(username);
		if(user != null) {
			System.out.println("into first if\n");
			if(user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				RequestDispatcher rd=request.getRequestDispatcher("HomePage");
				rd.forward(request, response);
			}

			else{
				out.println("Invalid Credentials!");
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");
				rd.include(request, response);
			}
		}
		else {
			out.println("Not a registered user");
			RequestDispatcher rd=request.getRequestDispatcher("/register.html");
			rd.include(request, response);
		}

		out.close();

	}
}
