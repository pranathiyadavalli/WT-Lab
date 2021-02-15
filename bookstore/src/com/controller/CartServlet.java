package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dto.Book;
import com.dto.User;


public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         int book_id = Integer.parseInt(request.getParameter("book"));
         
         UserDAO registerDao = new UserDAO();
         
        //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
         String userRegistered = registerDao.addToCart(book_id);
         
         if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
         {
            request.getRequestDispatcher("Cart.jsp").forward(request, response);
         }
         else   //On Failure, display a meaningful message to the User.
         {
            request.setAttribute("errMessage", userRegistered);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
         }
     }


}
