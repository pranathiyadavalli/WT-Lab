package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connect.DBConnection;
import com.dto.Book;
import com.dto.Cart;
import com.dto.User;




public class UserDAO {
	public static int user_id;
	 public String registerUser(User registerBean)
     {
         String fullName = registerBean.getFullName();
         String email = registerBean.getEmail();
         String userName = registerBean.getUserName();
         String password = registerBean.getPassword();
         String credit = registerBean.getCreditCard();
         
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into users(id,fullName,Email,userName,password, creditCard) values (NULL,?,?,?,?, ?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             preparedStatement.setString(1, fullName);
             preparedStatement.setString(2, email);
             preparedStatement.setString(3, userName);
             preparedStatement.setString(4, password);
             preparedStatement.setNString(5, credit);
             
             int i= preparedStatement.executeUpdate();
             
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
     }
	 
	 
	 public String authenticateUser(User loginBean)
     {
         String userName = loginBean.getUserName(); //Assign user entered values to temporary variables.
         String password = loginBean.getPassword();
 
         Connection con = null;
         Statement statement = null;
         ResultSet resultSet = null;
 
         String userNameDB = "";
         String passwordDB = "";
         int id;
 
         try
         {
             con = DBConnection.createConnection(); //Fetch database connection object
             statement = con.createStatement(); //Statement is used to write queries. Read more about it.
             resultSet = statement.executeQuery("select * from users"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
 
             while(resultSet.next()) 
             {
              userNameDB = resultSet.getString("userName"); //fetch the values present in database
              passwordDB = resultSet.getString("password");
              
 
               if(userName.equals(userNameDB) && password.equals(passwordDB))
               {
             
                  user_id = resultSet.getInt("id");
                  String credit1 = resultSet.getString("creditCard");
            	   return credit1; 
               }
             }
             }
             catch(SQLException e)
             {
                e.printStackTrace();
             }
             return "Invalid user credentials";
         }
	 
	 
	 public String addToCart(int book_id)
     {
         Connection con = null;
         PreparedStatement preparedStatement = null;
         BookDAO bookdao = new BookDAO();
         Book book = null;
		try {
			book = bookdao.getBook(book_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
         try
         {
        	 int quantity = 1;
             con = DBConnection.createConnection();
             String query = "insert into cart(cart_id,book_id,user_id,quantity) values (NULL,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             
             System.out.println(" cart daocalledd");
             
             preparedStatement.setInt(1, book.getId());
             preparedStatement.setInt(2, user_id);
             preparedStatement.setInt(3, quantity);
             
             int i= preparedStatement.executeUpdate();
             
             if (i!=0)  //Just to ensure data has been inserted into the database
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
          
		}
         return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
		
     }
	 public static List<Cart> listAll() throws SQLException {
	        List<Cart> listBook = new ArrayList<>();
	         
	        String sql = "SELECT * FROM cart";
	        System.out.println("called ");
	        Connection con = null;
	        Statement statement = null;
	         
	        con = DBConnection.createConnection(); //Fetch database connection object
	        statement = con.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	         
	        while (resultSet.next()) {
	            int id = resultSet.getInt("cart_id");
	            int book_id = resultSet.getInt("book_id");
	            int id1 = resultSet.getInt("user_id");
	            int quantity = resultSet.getInt("quantity");
	            System.out.println(id + " " + quantity);
	            BookDAO bookDAO = new BookDAO();
	            Book book = bookDAO.getBook(book_id);
	           
	            if (id1 == user_id) {
	            	Cart cart = new Cart(id, book, null, quantity);
	            	listBook.add(cart);
	            	System.out.println(cart);
	            }
	        }
	         
	        resultSet.close();
	        statement.close();
	        
	        return listBook;
	    }
     }

