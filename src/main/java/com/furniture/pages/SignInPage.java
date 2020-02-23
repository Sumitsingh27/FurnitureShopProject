package com.furniture.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.furniture.utils.Actions;
import com.furniture.utils.Screenshot;
import com.furniture.utils.WebElementsCollector;

public class SignInPage {

	// Creating Object for Logger
	static Logger log = Logger.getLogger(SignInPage.class.getName());

	public static final String file = "Properties/SignInPage.properties";

	public static void enterEmail(WebDriver driver, String email) {

		WebElement emailField = WebElementsCollector.getWebElement(driver, file, "enterEmail");
		Actions.waitForElementToBeVisible(emailField);
		Actions.sendKeysToElement(emailField, email);
		log.debug("Entered email as " + email + " Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}

	public static void enterPassword(WebDriver driver, String passWord) {

		WebElement passwordField = WebElementsCollector.getWebElement(driver, file, "enterPassword");
		Actions.waitForElementToBeVisible(passwordField);
		Actions.sendKeysToElement(passwordField, passWord);
		log.debug("Entered PassWord as " + passwordField + " Successful");
		Screenshot.getStepWiseScreenshot(driver);

	}

	public static void clickOnSignInTab(WebDriver driver) {

		WebElement signInTab = WebElementsCollector.getWebElement(driver, file, "signInButton");
		Actions.waitForElementToBeVisible(signInTab);
		Actions.clickOnElement(signInTab);
		log.debug("Click On SignIn button in SignIn Page Successful");

	}

	public static void clickOnClearTab(WebDriver driver) {

		WebElement clearTab = WebElementsCollector.getWebElement(driver, file, "clearButton");
		Actions.waitForElementToBeVisible(clearTab);
		Actions.clickOnElement(clearTab);
		log.debug("Click On Clear button in SignIn Page Successful");

	}

	public static void clickOnCreateAccount(WebDriver driver) {

		WebElement createAccount = WebElementsCollector.getWebElement(driver, file, "createYourAccount");
		Actions.waitForElementToBeVisible(createAccount);
		Actions.clickOnElement(createAccount);
		log.debug("Click On Create Your Account button in SignIn Page Successful");

	}

	public static void clickOnSignInViaOTP(WebDriver driver) {

		WebElement signInViaOtp = WebElementsCollector.getWebElement(driver, file, "signInThroughOtp");
		Actions.waitForElementToBeVisible(signInViaOtp);
		Actions.clickOnElement(signInViaOtp);
		log.debug("Click On SignIn Via OTP button in SignIn Page Successful");

	}

}
