package com.furniture.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Screenshot extends BaseTestClass {

	static WebDriver driver;
	// public static ExtentTest test;

	public static String getScreenshot(WebDriver driver, String result) throws IOException {
		String dateName = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		// String destination = "C:\\Users\\M1041815\\Desktop\\FailedTestsScreenshots\\"
		// + result + dateName + "screenshot.png";
		File src = (ts.getScreenshotAs(OutputType.FILE));

		String destination = System.getProperty("user.dir") + File.separator + "Screenshots\\" + result + dateName
				+ ".png";
		System.out.println(destination);
		File finalDestination = new File(destination);
		try {
			FileHandler.copy(src, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// extentTest.log(LogStatus.INFO, extentTest.addScreenCapture(destination));
		return destination;

	}

	public static void getStepWiseScreenshot(WebDriver driver) {
		String dateName = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		// String destination = "C:\\Users\\M1041815\\Desktop\\FailedTestsScreenshots\\"
		// + result + dateName + "screenshot.png";
		File src = (ts.getScreenshotAs(OutputType.FILE));

		String destination = System.getProperty("user.dir") + File.separator + "Screenshots\\" + dateName + ".png";
		System.out.println(destination);
		File finalDestination = new File(destination);
		try {
			FileHandler.copy(src, finalDestination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(destination);
			test.log(Status.INFO, "Taking Step ScreenShots",
					MediaEntityBuilder.createScreenCaptureFromPath(destination).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
