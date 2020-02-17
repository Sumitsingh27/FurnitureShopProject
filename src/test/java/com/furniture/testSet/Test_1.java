package com.furniture.testSet;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.furniture.pages.HomePage;
import com.furniture.pages.LoginPage;
import com.furniture.pages.RestAssuredPages;
import com.furniture.pages.SignInPage;




public class Test_1 extends BaseTestClass {
	
	//Creating Object for Logger
		static Logger log = Logger.getLogger(Test_1.class.getName());
	
	@Test
	public static void testCase1_Selection() throws FileNotFoundException {
		
		test = extent.createTest("testCase1");
		
		log.info("testCase1_Selection Start's");
		
		
		
// Register the User
		RestAssuredPages.registerUser("test@abc123.com", "2341231231", "Newuser", "Test@1234");
		//RestAssuredPages.home();
//Using the register User Logging in
//		HomePage.tapOnSignIn(driver);
//		SignInPage.enterEmail(driver, "test@test221.com");
//		SignInPage.enterPassword(driver, "Test@1234");
//		SignInPage.clickOnSignInTab(driver);
		
		
		log.info("testCase1_Selection End's");
	}
	

}
