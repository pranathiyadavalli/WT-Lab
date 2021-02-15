package com.dao;

import java.util.List;

import com.connect.DBConnection;
import com.dto.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {
	public static List<Book> listAllBooks() throws SQLException {
        List<Book> listBook = new ArrayList<>();
         
        String sql = "SELECT * FROM book";
        System.out.println("called ");
        Connection con = null;
        Statement statement = null;
         
        con = DBConnection.createConnection(); 
        statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        
        while (resultSet.next()) {
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
            System.out.println(id + " " + title);
            Book book = new Book(id, title, author, price);
            listBook.add(book);
            System.out.println(book);
        }
         
        resultSet.close();
        statement.close();
        
        return listBook;
    }
	
	public Book getBook(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM book WHERE book_id = ?";
         
        Connection con = null;
         
        con = DBConnection.createConnection();
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
             
            book = new Book(id, title, author, price);
        }
         
        resultSet.close();
        statement.close();
         
        return book;
    }
}
