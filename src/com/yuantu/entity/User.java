package com.yuantu.entity;

public class User {
	private String uId;//用户编号
	private String userName;//用户名
	private String pwd;//用户密码
	private String name;//真实姓名
	private String gender;//性别
	private Integer age;//年龄
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uId, String userName, String pwd, String name, String gender, Integer age) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.pwd = pwd;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", userName=" + userName + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + "]";
	}
	
	
}
