package com.furniture.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.furniture.browser.BrowserSelection;
import com.furniture.utils.Screenshot;

public class BaseTestClass {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	static BrowserSelection bs;
	 protected static WebDriver driver;

	@BeforeTest
	public static void testStartUp() throws InterruptedException {

		bs = new BrowserSelection();
		driver = bs.openBrowser();
		
		htmlReporter = new ExtentHtmlReporter("Reports/ExtentReportGeneratedTestCase1.html");
		extent = new ExtentReports();  //create object of ExtentReports
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report 	
		htmlReporter.loadConfig(System.getProperty("user.dir")+"\\src\\main\\resources\\extent-config.xml");
	}
	
	@AfterTest
	public static void testCleanUp() throws InterruptedException {
		Thread.sleep(2000);
		bs.closeBrowser(driver);
		bs.quitBrowser(driver);
		extent.flush();
		//report.close();
		

	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
		}
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
		if (result.getStatus() == ITestResult.FAILURE) {
			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			 test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			 
			String screenshot_path = Screenshot.getScreenshot(driver, result.getName());
			test.fail(result + " Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot_path).build());

		}
	}

}