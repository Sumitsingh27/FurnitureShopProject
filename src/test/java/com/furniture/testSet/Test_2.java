package com.furniture.testSet;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.furniture.pages.ChairSelectionPages;
import com.furniture.pages.FurnitureDescriptionPages;
import com.furniture.pages.HomePage;
import com.furniture.pages.RestAssuredPages;
import com.furniture.pages.SignInPage;
import com.furniture.utils.BaseTestClass;




public class Test_2 extends BaseTestClass {
	
	//Creating Object for Logger
		static Logger log = Logger.getLogger(Test_2.class.getName());
	
	@Test
	public static void testCase1_Selection() throws FileNotFoundException, SQLException {
		
		test = extent.createTest("testCase2");
		
		log.info("testCase2_Selection Start's");
		
		
		
// Register the User
		//RestAssuredPages.getAccessToken("test@why123.com", "Test@1234");
		//RestAssuredPages.home();
		HomePage.tapOnSignIn(driver);
		SignInPage.enterEmail(driver, "test@test98.com");
		SignInPage.enterPassword(driver, "Test@1234");
		SignInPage.clickOnSignInTab(driver);
		
		HomePage.tapOnChair(driver);
		ChairSelectionPages.selectCambridgeChair(driver);
		FurnitureDescriptionPages.ClickOnAddToCart(driver);
		
		HomePage.returnToHomePage(driver);
		HomePage.tapOnChair(driver);
		ChairSelectionPages.selectChairTest(driver);
		FurnitureDescriptionPages.ClickOnAddToCart(driver);
		
		HomePage.returnToHomePage(driver);
		
		
		RestAssuredPages.deleteFromCart("test@test98.com", "Test@1234", "Cambridge Chair");
		
		//HomePage.tapOnCart(driver);
		
		
		//dataBaseValidations.validateEmailFromDatabaseViaMobileNumber("4352678923", "test@why123.com");
//Using the register User Logging in
		//HomePage.tapOnSignIn(driver);
//		SignInPage.enterEmail(driver, "test@test221.com");
//		SignInPage.enterPassword(driver, "Test@1234");
//		SignInPage.clickOnSignInTab(driver);
		
		
		log.info("testCase2_Selection End's");
	}
	

}
