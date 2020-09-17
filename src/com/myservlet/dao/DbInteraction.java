package com.myservlet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.UserAccount;

public class DbInteraction {

	public boolean save(UserAccount userAccount) {

		int result;
		try {
			Connection con = DataAccessLogic.getConnection();
			Statement statement = con.createStatement();

			int id = getUserId(con, userAccount)+1;

			System.out.println("id" + id);
			String name = userAccount.getName();
			String password = userAccount.getPassword();

			String sql = "insert into user_account(id,name,password) " + "values(" + id + ",'" + name + "','" + password
					+ "')";

			System.out.println("sql=" + sql);
			result = statement.executeUpdate(sql);

			System.out.println("result: " + result);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return true;
	}

	private static int getUserId(Connection con, UserAccount userAccount) {
		int idno = 0;
		// Execute Query
		ResultSet rs;
		try {
			Statement statement = con.createStatement();
			rs = statement.executeQuery("select max(id) from user_account");

			while (rs.next()) {
				idno = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idno;

	}

	public boolean savebyPreparedstmt(UserAccount userAccount) {

		int result;
		try {
			
			Connection con = DataAccessLogic.getConnection();
			PreparedStatement pstmt = null;
			
			
			int id = getUserId(con,userAccount)+1;
					
			System.out.println("id" + id);
			String name = userAccount.getName();
			String password = userAccount.getPassword();

			String sql = "insert into user_account(id,name,password) values(?,?,?);";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(1, password);

			System.out.println("sql=" + sql);
			result = pstmt.executeUpdate(sql);

			System.out.println("result: " + result);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return true;
	}

}