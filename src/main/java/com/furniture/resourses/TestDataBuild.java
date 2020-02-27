package com.furniture.resourses;

import java.sql.SQLException;

import com.furniture.pojo.FeedBackPayLoad;
import com.furniture.pojo.Role;
import com.furniture.pojo.SignUpPayLoad;
import com.furniture.utils.JdbcConnecction;

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

	public FeedBackPayLoad feedBackToReply(String comments, String reply) throws SQLException {
		FeedBackPayLoad feedBackRply = new FeedBackPayLoad();
		feedBackRply.setComments(comments);
		feedBackRply.setFeedBackDate("2020-02-25");
		feedBackRply.setId(JdbcConnecction.getFeedbackIdFromDatabase(comments));
		feedBackRply.setReply(reply);
		feedBackRply.setUserId(JdbcConnecction.getFeedbackUserIdFromDatabase(comments));

		return feedBackRply;


	}
}
