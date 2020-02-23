package com.furniture.pojo;

public class SignUpPayLoad {
	private String emailId;
	private String gender;
	private String mobileNo;
	private String name;
	private String password;
	private Role role;
	private String userStatus;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailID(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

//	public static String getPostData(String email, String mobileNo, String name, String passWord) {
//		String payLoad = "{\r\n  \"emailId\": \""+email+"\",\r\n  \"\",\r\n  \"mobileNo\": \""+mobileNo+"\",\r\n  \"name\": \""+name+"\",\r\n  \"password\": \""+passWord+"\",\r\n  \"}";
//		return payLoad;
//	}

}
