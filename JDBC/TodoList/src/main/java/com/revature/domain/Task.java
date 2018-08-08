package com.revature.domain;

import java.util.List;

/**
 * Task Class in Domain
 * @author sidhu
 *
 */
public class Task {
	
	//states
	private int taskId;
	private int userId;
	private String taskName;
	private int taskStatusId;
	private String taskStatusLevel;
	public int getTaskId() {
		return taskId;
	}
	
	//NO-ARGS
	public Task() {}
	
	//getters n' setters
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public int getTaskStatusId() {
		return taskStatusId;
	}
	public void setTaskStatusId(int taskStatusId) {
		this.taskStatusId = taskStatusId;
	}
	public String getTaskStatusLevel() {
		return taskStatusLevel;
	}
	public void setTaskStatusLevel(String taskStatusLevel) {
		this.taskStatusLevel = taskStatusLevel;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", userId=" + userId + ", taskName=" + taskName + ", taskStatusLevel="
				+ taskStatusLevel + "]";
	}
	
}