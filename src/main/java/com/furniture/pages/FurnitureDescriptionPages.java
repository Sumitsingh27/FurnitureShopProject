package com.furniture.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.furniture.utils.Actions;
import com.furniture.utils.Screenshot;
import com.furniture.utils.WebElementsCollector;

public class FurnitureDescriptionPages {
	public static final String file = "Properties/FurnitureDescription.properties";

	static Logger log = Logger.getLogger(FurnitureDescriptionPages.class.getName());
	
	public static void ClickOnAddToCart(WebDriver driver) {
		WebElement addToCartButton = WebElementsCollector.getWebElement(driver, file, "addToCartButton");
		Actions.waitForElementToBeVisible(addToCartButton);
		Actions.clickOnElement(addToCartButton);
		log.debug("Selected item added to Cart");
		Screenshot.getStepWiseScreenshot(driver);

	}
	
	public static void ClickOnBuyNow(WebDriver driver) {
		WebElement buyNowButton = WebElementsCollector.getWebElement(driver, file, "buyNowButton");
		Actions.waitForElementToBeVisible(buyNowButton);
		Actions.clickOnElement(buyNowButton);
		log.debug("Clicked on Buy Now  Button");
		Screenshot.getStepWiseScreenshot(driver);

	}
	
	public static void ClickOnAddToWhislist(WebDriver driver) {
		WebElement wishListButton = WebElementsCollector.getWebElement(driver, file, "addToWhislist");
		Actions.waitForElementToBeVisible(wishListButton);
		Actions.clickOnElement(wishListButton);
		log.debug("Clicked on Buy Now  Button");
		Screenshot.getStepWiseScreenshot(driver);

	}
	
}
