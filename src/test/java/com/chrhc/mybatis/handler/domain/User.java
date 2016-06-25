package com.chrhc.mybatis.handler.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 9030785649977959711L;

	private Integer id;
	private String name;
	private String password;
	private UserType userType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", userType=" + userType + "]";
	}

}
