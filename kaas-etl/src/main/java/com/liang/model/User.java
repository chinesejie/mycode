package com.liang.model;

/**
 * table user!
 * 
 */
public class User {

	private String address;
	private String email;
	private String region;
	private int user_id;
	private String user_name;

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getRegion() {
		return region;
	}

	public int getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
