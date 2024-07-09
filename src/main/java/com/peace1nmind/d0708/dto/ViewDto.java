package com.peace1nmind.d0708.dto;

public class ViewDto {
	
	private String boardnum;
	private int viewFlag;
	
	
	public ViewDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ViewDto(String boardnum, int viewFlag) {
		super();
		this.boardnum = boardnum;
		this.viewFlag = viewFlag;
	}


	public String getBoardnum() {
		return boardnum;
	}


	public void setBoardnum(String boardnum) {
		this.boardnum = boardnum;
	}


	public int getViewFlag() {
		return viewFlag;
	}


	public void setViewFlag(int viewFlag) {
		this.viewFlag = viewFlag;
	}
	
	

}
