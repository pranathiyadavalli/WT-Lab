package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.User;
@WebServlet("/HomePage")
public class HomePage extends HttpServlet {

	public HomePage() {
		System.out.println("**HomePage object is created");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String fullname = user.getFullname();
		System.out.println(fullname);
		PrintWriter out=response.getWriter();
		out.print("<html><body style=\"background-color:powderblue;\">");
		out.print("<center>");
		out.print("<h2> Hi " + fullname);
		out.print("<h2>Welcome to Home Page");
		out.print("<br><h5><a href=\"login.html\"> Logout  </a>");
		out.print("</center>");

		out.print("</body></html>");
		out.close();
	}
}

