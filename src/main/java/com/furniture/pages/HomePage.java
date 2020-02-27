package com.furniture.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.furniture.utils.Actions;
import com.furniture.utils.Screenshot;
import com.furniture.utils.WebElementsCollector;

public class HomePage {

	public static final String file = "Properties/HomePage.properties";

	static Logger log = Logger.getLogger(HomePage.class.getName());

	public static void tapOnSignIn(WebDriver driver) {
		WebElement signIn = WebElementsCollector.getWebElement(driver, file, "signInButton");
		Actions.waitForElementToBeVisible(signIn);
		Actions.clickOnElement(signIn);
		log.debug("Click SignIn Button Successful");
		Screenshot.getStepWiseScreenshot(driver);

	}

	public static void tapOnCart(WebDriver driver) {
		WebElement cart = WebElementsCollector.getWebElement(driver, file, "cartButton");
		Actions.waitForElementToBeVisible(cart, 60);
		Actions.clickOnElement(cart);
		log.debug("Click on Cart Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}

	public static void tapOnChair(WebDriver driver) {
		WebElement chair = WebElementsCollector.getWebElement(driver, file, "chairCircle");
		Actions.waitForElementToBeVisible(chair);
		Actions.clickOnElement(chair);
		log.debug("Click on Cart Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}

	public static void tapOnSofa(WebDriver driver) {
		WebElement sofa = WebElementsCollector.getWebElement(driver, file, "sofaCircle");
		Actions.waitForElementToBeVisible(sofa);
		Actions.clickOnElement(sofa);
		log.debug("Click on Cart Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}

	public static void tapOnTable(WebDriver driver) {
		WebElement table = WebElementsCollector.getWebElement(driver, file, "tableCircle");
		Actions.waitForElementToBeVisible(table);
		Actions.clickOnElement(table);
		log.debug("Click on Cart Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}

	public static void tapOnBed(WebDriver driver) {
		WebElement bed = WebElementsCollector.getWebElement(driver, file, "bedCircle");
		Actions.waitForElementToBeVisible(bed);
		Actions.clickOnElement(bed);
		log.debug("Click on Cart Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}
	
	public static void returnToHomePage(WebDriver driver) {
		WebElement returnhomePage = WebElementsCollector.getWebElement(driver, file, "returnToHomePage");
		Actions.waitForElementToBeVisible(returnhomePage);
		Actions.clickOnElement(returnhomePage);
		log.debug("Click Home Page Button Successful");
		Screenshot.getStepWiseScreenshot(driver);

	}
	
	public static void tapOnUserDetails(WebDriver driver) {
		WebElement userDetails = WebElementsCollector.getWebElement(driver, file, "userDetails");
		Actions.waitForElementToBeVisible(userDetails);
		Actions.clickOnElement(userDetails);
		log.debug("Click on Userdetails Successful");
		Screenshot.getStepWiseScreenshot(driver);

	}
}
