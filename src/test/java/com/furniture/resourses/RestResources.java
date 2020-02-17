package com.furniture.resourses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.furniture.pages.RestAssuredPages;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestResources {

	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static File file;

	//Creating Object for Logger
	static Logger log = Logger.getLogger(RestAssuredPages.class.getName());

	static RequestSpecification request;

	public static RequestSpecification requestSpecification() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("RestLogging"));
		request = new RequestSpecBuilder().setBaseUri(getGlobalValue("restBaseURI"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType("application/json")
				.build();
		return request;
	}

	public static String getGlobalValue( String key) {
		try {
			file = new File("Properties/Global.properties");
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			log.error("Unable to find the file" + file);
			e.printStackTrace();
		}
		try {
			prop.load(fis);

		} catch (IOException e) {
			log.error("The File not get Loaded");
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
