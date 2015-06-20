package com.seele.Test;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class User implements java.io.Serializable {
	private Integer userId;
	private String userName;
	private String password;
	private String mobile;
	private String email;
	public User() {
		super();
	}
	public User(Integer userId, String userName, String password, String mobile, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", mobile=" + mobile + ", password="
				+ password + ", userId=" + userId + ", userName=" + userName
				+ "]";
	}
	
	public static void main(String[] args) {
		try {
			//内省(Introspector)
			PropertyDescriptor[] pd = Introspector.getBeanInfo(User.class).getPropertyDescriptors();
			for (int i = 0; i < pd.length; i++) {
				System.out.println(pd[i].getName() + " ("
						+ pd[i].getPropertyType().getName() + ")");
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}
}
