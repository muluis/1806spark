package com.revature.domain;

import java.io.Serializable;
import java.util.List;

/**
 * User
 * @author tyler
 *
 */

public class User implements Serializable {
	
	private int userId;
	private String username;
	private String password;
	
	//Since we know users will have multiple tasks, use a collection or array to hold them
	
	private List<Task> userTasks;
	
	
	public User() {}

	public User(int userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Task> getUserTasks() {
		return userTasks;
	}


	public void setUserTasks(List<Task> userTasks) {
		this.userTasks = userTasks;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userTasks="
				+ userTasks + "]";
	}




}
