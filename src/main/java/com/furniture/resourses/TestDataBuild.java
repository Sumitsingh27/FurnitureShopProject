package com.furniture.resourses;

import com.furniture.pojo.Role;
import com.furniture.pojo.SignUpPayLoad;

public class TestDataBuild {

	public SignUpPayLoad signUpMember(String email, String mobileNo, String name, String passWord) {
		SignUpPayLoad signUp = new SignUpPayLoad();
		Role role = new Role();
		signUp.setEmailID(email);
		signUp.setMobileNo(mobileNo);
		signUp.setName(name);
		signUp.setPassword(passWord);
		signUp.setGender("MALE");
		role.setDescription("Registration of User");
		role.setName("NewUser");
		role.setRoleId(2222);
		signUp.setRole(role);
		signUp.setUserStatus("ACTIVE");
		return signUp;

	}

	public static String payLoadCheck() {
		String body = "{\r\n  \"emailId\": \"adcd@123.com\",\r\n  \"gender\": \"MALE\",\r\n  \"mobileNo\": \"7658904321\",\r\n  \"name\": \"Soumya\",\r\n  \"password\": \"Test@1234\",\r\n  \"role\": {\r\n    \"description\": \"string\",\r\n    \"name\": \"Admin, user, etc..\",\r\n    \"roleId\": 1234\r\n  },\r\n  \"userStatus\": \"ACTIVE\"\r\n}";
		
		return body;
	}
}
