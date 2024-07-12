package com.peace1nmind.d0708.dao;

import java.util.ArrayList;

import com.peace1nmind.d0708.dto.CommentDto;

public interface CommentDao {
	
	// 댓글 작성
	public void comment(String boardnum, String nickname, String comments);
	
	// 댓글 내용
	public ArrayList<CommentDto> commentList(String boardnum);

}
