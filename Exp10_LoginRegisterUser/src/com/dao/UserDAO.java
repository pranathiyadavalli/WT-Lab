package com.dao;
import java.sql.*;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.db.DbConnection;

import com.dto.User;

public class UserDAO {
	public User getUser(String username, String password) {

		Connection conn = null;
		conn = DbConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = new User();

		String SELECT = "Select * from user where username=? and password=?";

		try {

			pst = conn.prepareStatement(SELECT);
			pst.setString(1,  username);
			pst.setString(2,  password);
			rs = pst.executeQuery();

			if(rs.next()) {
				user.setUsername(rs.getString(1));
				user.setFullname(rs.getString(2));
				user.setPassword(rs.getString(3));

				return user;

			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}

	public  int register(User user) {
		Connection conn = null;
		conn = DbConnection.getConnection();
		PreparedStatement pst = null;
		String INSERT = "insert into user values(?,?,?)";
		try {

			pst = conn.prepareStatement(INSERT);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getFullname());
			pst.setString(3, user.getPassword());
			
			

			int result = pst.executeUpdate();
			return result;

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}
	

	public User getUserByUsername(String username) {
		Connection conn = null;
		conn = DbConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = new User();

		String SELECT = "Select * from user where username=?";

		try {

			pst = conn.prepareStatement(SELECT);
			pst.setString(1,  username);

			rs = pst.executeQuery();

			if(rs.next()) {
				user.setUsername(rs.getString(1));
				user.setFullname(rs.getString(2));
				user.setPassword(rs.getString(3));

				return user;

			} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}
}

	

	

	


