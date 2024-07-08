package com.peace1nmind.d0708.dto;

public class BoardDto {
	
	private int boardnum;
	private String nickname;
	private String writer;
	private String title;
	private String content;
	private int hit;
	private String postdate;
	
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardDto(int boardnum, String nickname, String writer, String title, String content, int hit,
			String postdate) {
		super();
		this.boardnum = boardnum;
		this.nickname = nickname;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.postdate = postdate;
	}


	public int getBoardnum() {
		return boardnum;
	}


	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getPostdate() {
		return postdate;
	}


	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	
	
	

}
