package com.peace1nmind.d0708.dto;

public class BoardDto {
	
	private String boardnum;
	private String nickname;
	private String writer;
	private String title;
	private String content;
	private int hit;
	private String postdate;
	private String editdate;
	
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardDto(String boardnum, String nickname, String writer, String title, String content, int hit,
			String postdate, String editdate) {
		super();
		this.boardnum = boardnum;
		this.nickname = nickname;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.postdate = postdate;
		this.editdate = editdate;
	}


	public String getBoardnum() {
		return boardnum;
	}


	public void setBoardnum(String boardnum) {
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


	public String getEditdate() {
		return editdate;
	}


	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}
	
	
}
