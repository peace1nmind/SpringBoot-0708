package com.peace1nmind.d0708.dao;

import java.util.ArrayList;

import com.peace1nmind.d0708.dto.BoardDto;

public interface BoardDao {
	
	// 글 작성
	public void write(String nickname, String writer, String title, String contnet);
	
	// 글 목록
	public ArrayList<BoardDto> list();
	
	// 글 내용
	public BoardDto content(String boardnum);
	
	// 조회수 증가
	public void hitUp(String boardnum);
	
	// 글 수정
	public void editPost(String title, String content, String editDate, String boardnum);
	
	// 글 삭제
	public void delete(String boardnum);
	
}
