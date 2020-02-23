package com.furniture.testSet;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.furniture.pages.HomePage;
import com.furniture.pages.RestAssuredPages;
import com.furniture.utils.BaseTestClass;




public class Test_1 extends BaseTestClass {
	
	//Creating Object for Logger
		static Logger log = Logger.getLogger(Test_1.class.getName());
	
	@Test
	public static void testCase1_Selection() throws FileNotFoundException, SQLException {
		
		test = extent.createTest("testCase1");
		
		log.info("testCase1_Selection Start's");
		
		
		
// Register the User
		//RestAssuredPages.registerUser("test@why123.com", "4352678923", "Newuser", "Test@1234");
		RestAssuredPages.home();
		//dataBaseValidations.validateEmailFromDatabaseViaMobileNumber("4352678923", "test@why123.com");
//Using the register User Logging in
		HomePage.tapOnSignIn(driver);
//		SignInPage.enterEmail(driver, "test@test221.com");
//		SignInPage.enterPassword(driver, "Test@1234");
//		SignInPage.clickOnSignInTab(driver);
		
		
		log.info("testCase1_Selection End's");
	}
	

}
