package com.furniture.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnecction {
	static String host = "";
	static String port ="";
	public static void dataBaseConnection() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root", "root");

		Statement s=con.createStatement();

		ResultSet rs=s.executeQuery("select * from credentials where scenario ='rewardscard'");

		while(rs.next())

		{

			rs.getString("username");

			rs.getString("password");

		}
	}

}