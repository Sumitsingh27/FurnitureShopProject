package com.furniture.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnecction {

	// @Test
	public static Statement jdbcConnection() throws SQLException {
		Statement s= null;
		String URL = "jdbc:mysql://okmry52647dns.eastus.cloudapp.azure.com:3306/bmf-abhishek-jun19-dev?"
				+ "useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection(URL, "sdetuser1", "Welcome123$");
			s = con.createStatement();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;

	}
	
	public static String getEmailFromDatbase(String mobileNumber) throws SQLException {
		String results = null;
		ResultSet rs = jdbcConnection().executeQuery("Select * from profile where mobile_no = '"+mobileNumber+"'");
		while (rs.next())		
						{
							 results = rs.getString("email_id");
							System.out.println(rs.getString("email_id"));
			
						}
		return results;
	}
	
	public static int getUserIdFromDatbase(String email) throws SQLException {
		String results = null;
		ResultSet rs = jdbcConnection().executeQuery("Select * from profile where email_id = '"+email+"'");
		while (rs.next())		
						{
							 results = rs.getString("user_id");
							System.out.println(rs.getString("email_id"));
			
						}
		return Integer.parseInt(results);
	}
	
	public static int getFeedbackUserIdFromDatabase(String comments) throws SQLException {
		String results = null;
		ResultSet rs = jdbcConnection().executeQuery("Select * from feedback where comments = '"+comments+"'");
		while (rs.next())		
						{
							 results = rs.getString("user_id_user_id");
							System.out.println(rs.getString("user_id_user_id"));
						}
		return Integer.parseInt(results);
	}
	
	public static int getFeedbackIdFromDatabase(String comments) throws SQLException {
		String results = null;
		ResultSet rs = jdbcConnection().executeQuery("Select * from feedback where comments = '"+comments+"'");
		while (rs.next())		
						{
							 results = rs.getString("id");
							System.out.println(rs.getString("id"));
						}
		return Integer.parseInt(results);
	}
	
	public static int getCartIdFromDataBase(int userId, int productId) throws SQLException {
		String results = null;
		ResultSet rs = jdbcConnection().executeQuery("Select * from cart where profile_user_id = '"+userId+"'" + "and product_id = '"+productId+"'");
		while (rs.next())		
						{
							 results = rs.getString("cart_id");
							System.out.println(rs.getString("cart_id"));
						}
		return Integer.parseInt(results);
	}
}