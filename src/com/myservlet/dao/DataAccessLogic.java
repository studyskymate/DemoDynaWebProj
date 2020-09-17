package com.myservlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataAccessLogic {

public static Connection getConnection() throws SQLException, ClassNotFoundException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@CEIT-SRV-1.fnu.local:1521/orcl.fnu.local","hr","hr");
	return con;
}	
}
