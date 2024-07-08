package com.peace1nmind.d0708.dto;

public class PhoneDto {
	
	private String phone1;
	private String phone2;
	private String phone3;
	
	
	public PhoneDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PhoneDto(String phone1, String phone2, String phone3) {
		super();
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
	}


	public String getPhone1() {
		return phone1;
	}


	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}


	public String getPhone2() {
		return phone2;
	}


	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}


	public String getPhone3() {
		return phone3;
	}


	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

}
