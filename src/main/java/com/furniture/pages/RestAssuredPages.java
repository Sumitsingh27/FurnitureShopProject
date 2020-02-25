package com.furniture.pages;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;

import com.furniture.resourses.RawToFormatedType;
import com.furniture.resourses.RestResources;
import com.furniture.resourses.TestDataBuild;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RestAssuredPages extends RestResources {
	static RequestSpecification request;
	static ResponseSpecification resSpec;
	static Response response;
	static TestDataBuild data = new TestDataBuild();

	// Creating Object for Logger
	static Logger log = Logger.getLogger(RestAssuredPages.class.getName());

	public static void registerUser(String email, String mobileNo, String name, String passWord)
			throws FileNotFoundException {
		request = given().spec(requestSpecification()).header("Content-Type", "application/json").body(data.signUpMember(email, mobileNo, name, passWord));
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = request.when().post("/rest/api/signup/").then().spec(resSpec).extract().response();
	}

	public static void home() throws FileNotFoundException {
		request = given().spec(requestSpecification());
		// .header("Content-Type", "application/json");

		response = request.when().get("");
		// .then().spec(resSpec).extract().response();
	}
	
	public static String getAccessToken(String emailId, String passWord) throws FileNotFoundException {
		String accessToken = null;
		request = given().spec(requestSpecification())
				.header("Content-Type", "application/x-www-form-urlencoded")
				.header("Authorization", "Basic amFtYWxDbGllbnRIZXJlOmphbWFsU2VjcmV0SGVyZQ==")
				.queryParam("username", emailId)
				.queryParam("password", passWord)
				.queryParam("grant_type", "password");
				resSpec = new ResponseSpecBuilder()
						.expectContentType(ContentType.JSON)
						.build();
		response = request.when().post("/oauth/token").then().spec(resSpec).extract().response();		
		 accessToken = RawToFormatedType.rawToJson(response).get("access_token");
		 System.out.println(accessToken);
		 return accessToken;
		
	}

}
