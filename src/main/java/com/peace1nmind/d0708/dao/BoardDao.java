package com.peace1nmind.d0708.dao;

public interface BoardDao {
	
	// 글 작성
	public void write(String nickname, String writer, String title, String contnet);
}
