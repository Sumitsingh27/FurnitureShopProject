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
}