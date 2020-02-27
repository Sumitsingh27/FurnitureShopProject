package com.furniture.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.furniture.utils.Actions;
import com.furniture.utils.Screenshot;
import com.furniture.utils.WebElementsCollector;

public class FeedBackpages {
	public static final String file = "Properties/FeedBack.properties";

	static Logger log = Logger.getLogger(FurnitureDescriptionPages.class.getName());
	
	public static void tapOnFeedBack(WebDriver driver) {
		WebElement feedBack = WebElementsCollector.getWebElement(driver, file, "feedBack");
		Actions.waitForElementToBeVisible(feedBack);
		Actions.clickOnElement(feedBack);
		log.debug("Click on Feedback Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}
	
	public static void enterEmail(WebDriver driver, String feedback) {

		WebElement feedBackField = WebElementsCollector.getWebElement(driver, file, "addComments");
		Actions.waitForElementToBeVisible(feedBackField);
		Actions.sendKeysToElement(feedBackField, feedback);
		log.debug("Entered email as " + feedback + " Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}
	
	public static void tapOnFeedbackSubmit(WebDriver driver) {
		WebElement feedBackSubmit = WebElementsCollector.getWebElement(driver, file, "feedBackSubmit");
		Actions.waitForElementToBeVisible(feedBackSubmit);
		Actions.clickOnElement(feedBackSubmit);
		log.debug("Click on Feedback Successful");
		Screenshot.getStepWiseScreenshot(driver);
	}
}
