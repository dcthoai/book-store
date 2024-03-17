package com.springmvc.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Customer extends AbstractModel {
	private String username, fullname, phoneNumber, email, password;
	private int avatar;
	private Date birthday;

	public Customer() {
		super();
	}

	public Customer(int id, Timestamp createdDate, Timestamp modifiedDate, String createdBy, String modifiedBy) {
		super(id, createdDate, modifiedDate, createdBy, modifiedBy);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}