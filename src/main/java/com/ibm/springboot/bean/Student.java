package com.ibm.springboot.bean;

public class Student {
	private Integer id;
	private String username;
	private String password;
	private String stuclass;
	private String stuname;
	private String stuno;
	private Double score;
	private Boolean States;
	private String  priority;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getStuclass() {
		return stuclass;
	}
	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Boolean getStates() {
		return States;
	}
	public void setStates(Boolean states) {
		States = states;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", username=" + username + ", password=" + password + ", stuclass=" + stuclass
//				+ ", stuname=" + stuname + ", stuno=" + stuno + ", score=" + score + ", States=" + States
//				+ ", priority=" + priority + "]";
//	}
//	
	
}
