/* 댓글 DTO */

package com.peace1nmind.d0708.dto;

public class CommentDto {
	
	private String boardnum;
	private String nickname;
	private String comments;
	private String commentdate;
	private int good;
	private int bad;
	
	
	public CommentDto(){
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentDto(String boardnum, String nickname, String comments, String commentdate, int good, int bad) {
		super();
		this.boardnum = boardnum;
		this.nickname = nickname;
		this.comments = comments;
		this.commentdate = commentdate;
		this.good = good;
		this.bad = bad;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}

	public int getGood() {
		return good;
	}

	public void setGood(int good) {
		this.good = good;
	}

	public int getBad() {
		return bad;
	}

	public void setBad(int bad) {
		this.bad = bad;
	}

}
