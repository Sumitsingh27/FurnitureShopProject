package com.furniture.pages;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.furniture.resourses.RawToFormatedType;
import com.furniture.resourses.RestResources;
import com.furniture.resourses.TestDataBuild;
import com.furniture.utils.JdbcConnecction;

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
		request = given().spec(requestSpecification()).header("Content-Type", "application/json")
				.body(data.signUpMember(email, mobileNo, name, passWord));
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = request.when().post("/rest/api/signup/").then().spec(resSpec).extract().response();
	}

	public static void home() throws FileNotFoundException {
		request = given().spec(requestSpecification());
		response = request.when().get("")
		.then().assertThat().statusCode(200).extract().response();
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
		 //System.out.println(accessToken);
		 return accessToken;
		
	}
	
	public static void feedbackReply(String comments, String reply) throws FileNotFoundException, SQLException {
		request = given().spec(requestSpecification())
				.body(data.feedBackToReply(comments, reply));
		resSpec = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
		response = request.when()
				.put("/rest/api/feedback/reply")
				.then()
				.spec(resSpec).assertThat().statusCode(200).extract().response();
				
	}
	
	public static void deleteFromCart(String email, String password, String itemName) throws FileNotFoundException, SQLException {
		int product_Id= 0;
		int cart_id=0;
		if(itemName.equalsIgnoreCase("Cambridge Chair")) {
			product_Id = 3;
		} else if(itemName.equalsIgnoreCase("Test123 Chair")) {
			product_Id = 1;
		} else if(itemName.equalsIgnoreCase("ChairTest")) {
			product_Id = 2;
		}
		cart_id = JdbcConnecction.getCartIdFromDataBase(JdbcConnecction.getUserIdFromDatbase(email), product_Id);
		request = given().spec(requestSpecification())
				.header("Authorization" , "Bearer "+ getAccessToken(email, password))
				.pathParam("cart_id", cart_id);
		resSpec = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
		response = request.when()
				.delete("/rest/api/cart/{cart_id}")
				.then()
				.spec(resSpec).assertThat().statusCode(200).extract().response();
	}


}
