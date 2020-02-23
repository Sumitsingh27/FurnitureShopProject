package com.furniture.resourses;

import static org.testng.Assert.assertTrue;

import java.sql.SQLException;

import com.furniture.utils.JdbcConnecction;

public class dataBaseValidations extends JdbcConnecction {

	public static void validateEmailFromDatabaseViaMobileNumber(String mobileNumber, String emailId) throws SQLException {
		assertTrue(getEmailFromDatbase(mobileNumber).equalsIgnoreCase(emailId));
	}
}
