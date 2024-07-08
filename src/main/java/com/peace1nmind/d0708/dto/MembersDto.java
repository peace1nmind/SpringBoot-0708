package com.peace1nmind.d0708.dto;

public class MembersDto {
	
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String signupdate;
	
	
	public MembersDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MembersDto(String id, String pw, String name, String nickname, String phone, String email,
			String signupdate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.signupdate = signupdate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSignupdate() {
		return signupdate;
	}


	public void setSignupdate(String signupdate) {
		this.signupdate = signupdate;
	}
	
	

}
