package com.infamous.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class UserModel {

	@Id
	private String userid;

	private String name;

	private String email;

	private String phone;

	public UserModel() {
	}

	public UserModel(String id) {
		this.userid = id;
	}

	public UserModel(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public UserModel(String userid, String name, String email, String phone) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}