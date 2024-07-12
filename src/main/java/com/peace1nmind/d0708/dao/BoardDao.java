package com.peace1nmind.d0708.dao;


import java.util.ArrayList;

import com.peace1nmind.d0708.dto.BoardDto;

public interface BoardDao {
	
	// 글 작성
	public void write(String nickname, String writer, String title, String contnet);
	
	// 글 목록
	public ArrayList<BoardDto> list(int amount, int pageNum);
	
	// 글 내용
	public BoardDto content(String boardnum);
	
	// 조회수 증가
	public void hitUp(String boardnum);
	
	// 글 수정
	public void editPost(String title, String content, String editDate, String boardnum);
	
	// 글 삭제
	public void delete(String boardnum);
	
	// 글 검색
	public ArrayList<BoardDto> search_byTitle(String searchDetail, int amount, int pageNum);			// 제목 검색
	public ArrayList<BoardDto> search_byTitleContent(String searchDetail, int amount, int pageNum);		// 제목+내용 검색
	public ArrayList<BoardDto> search_byNickname(String searchDetail, int amount, int pageNum);			// 닉네임 검색
	public ArrayList<BoardDto> search_byWriter(String searchDetail, int amount, int pageNum);			// 작성자 검색
	
	// 게시판 총 글 수
	public int boardTotalCount();
	
	// 글 검색 총 글 수
	public int searchTotalCount_byTitle(String searchDtail);			// 제목 검색 총 글 수
	public int searchTotalCount_byTitleContent(String searchDtail);		// 제목+내용 검색 총 글 수
	public int searchTotalCount_byNickname(String searchDtail);			// 닉네임 검색 총 글 수
	public int searchTotalCount_byWriter(String searchDtail);			// 작성자 검색 총 글 수
	
	
}
