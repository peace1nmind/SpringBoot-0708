package com.peace1nmind.d0708.dto;

public class EmailDto {
	
	private String emailUser;
	private String emailDomain;
	
	
	public EmailDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmailDto(String emailUser, String emailDomain) {
		super();
		this.emailUser = emailUser;
		this.emailDomain = emailDomain;
	}


	public String getEmailUser() {
		return emailUser;
	}


	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}


	public String getEmailDomain() {
		return emailDomain;
	}


	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	
	
}
