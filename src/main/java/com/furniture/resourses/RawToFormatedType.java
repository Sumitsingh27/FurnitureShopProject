package com.furniture.resourses;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RawToFormatedType {
	
	public static JsonPath rawToJson(Response respo) {
		String response = respo.asString();
		JsonPath jsonFormat = new JsonPath(response);
		return jsonFormat;
	}

}
