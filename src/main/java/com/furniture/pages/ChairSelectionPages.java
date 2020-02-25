package com.furniture.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.furniture.utils.Actions;
import com.furniture.utils.Screenshot;
import com.furniture.utils.WebElementsCollector;

public class ChairSelectionPages {
	public static final String file = "Properties/ChairSelection.properties";

	static Logger log = Logger.getLogger(ChairSelectionPages.class.getName());

	
	/**
	 * @param driver
	 */
	public static void selectChairTest(WebDriver driver) {
		WebElement chairTest = WebElementsCollector.getWebElement(driver, file, "selectChairTest");
		Actions.waitForElementToBeVisible(chairTest);
		Actions.clickOnElement(chairTest);
		log.debug("Chair Test is selected");
		Screenshot.getStepWiseScreenshot(driver);

	}
	
	public static void selectCambridgeChair(WebDriver driver) {
		WebElement cambridgeChair = WebElementsCollector.getWebElement(driver, file, "selectCambridgeChair");
		Actions.waitForElementToBeVisible(cambridgeChair);
		Actions.clickOnElement(cambridgeChair);
		log.debug("Chair Test is selected");
		Screenshot.getStepWiseScreenshot(driver);

	}
}
